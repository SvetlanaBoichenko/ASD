import java.lang.reflect.Array;

public class DynArrayN<T> {
    public T[] array;
    Class clazz;
    public int[] koef_arr;
    public int nlen;
    public int[] size;

    public DynArrayN(Class clz, int dim, int[] dim_arr) {
        clazz = clz;
        size = new int[dim];

        for (int i = 0; i < dim; i++) {
            size[i] = dim_arr[i];
        }
        koef_arr = new int[dim];
        make_newkoef();
        makeArray(dim_arr);
    }

    public void make_newkoef() {
        int dim = this.size.length;
        for (int i = dim - 1; i >= 0; i--) {
            if (i == dim - 1) {
                this.koef_arr[i] = 1;
                continue;
            }
            this.koef_arr[i] = this.koef_arr[i + 1] * this.size[i + 1];
        }
    }

    public void makeArray(int[] dim_arr)//
    {
        nlen = 1;
        for (int i = 0; i < dim_arr.length; i++) {
            nlen *= dim_arr[i];
        }

        this.array = (T[]) Array.newInstance(this.clazz, nlen);  // 1 dim
    }

    public int[] make_cord_base(int c_abs, int[] coef_arr) {
        int n = coef_arr.length;
        int[] cord_arr = new int[n];
        int d = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                cord_arr[i - 1] = c_abs / coef_arr[i - 1];
                d = c_abs % coef_arr[i - 1];
                continue;
            }
            cord_arr[i - 1] = d / coef_arr[i - 1];
            d = d % coef_arr[i - 1];
        }
        return cord_arr;
    }

    public int[] make_cord(int c_abs) {
        return make_cord_base(c_abs, this.koef_arr);
    }

    public int make_casb_base(int[] cord_arr, int[] coef_arr) {
        int n = cord_arr.length;
        int abs_co = 0;
        for (int i = 0; i < n; i++) {
            abs_co += coef_arr[i] * cord_arr[i];
        }
        return abs_co;
    }

    public int make_casb(int[] cord_arr) {
        return make_casb_base(cord_arr, this.koef_arr);
    }

    public T getItem(int[] index) {
        int ind_abs = this.make_casb(index);
        return this.array[ind_abs];
    }

    public void resize(int[] new_size) {
        int new_nlen = 1;
        for (int i = 0; i < new_size.length; i++) {
            new_nlen *= i;
        }

        T[] old_array = (T[]) Array.newInstance(this.clazz, this.nlen);
        for (int i = 0; i < this.nlen; i++) {
            old_array[i] = this.array[i];
        }

        int[] old_koef = new int[size.length];
        for (int i = 0; i < this.koef_arr.length; i++) {
            old_koef[i] = this.koef_arr[i];
        }

        makeArray(new_size);
        make_newkoef();

        for (int i = 0; i < this.nlen; i++) {
            int[] cord = make_cord(i);
            int old_abs_co = make_casb_base(cord, old_koef);
            this.array[i] = old_array[old_abs_co];
        }
    }


}


