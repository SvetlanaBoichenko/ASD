//import java.lang.reflect.Array;
import java.lang.reflect.Array;
import java.util.*;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray (int new_capacity)// new capacity - занять память
    {
        this.array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
     //  this.array = myarr;
        // переписывание массива тут же
    }


    public T getItem(int index)
    {
        if (index >= this.count)
            return null;

        return this.array[index];
    }


    public void append(T itm)
    {
        if (this.capacity < this.count + 1) {
            T[] myarr = this.array;
            makeArray(this.capacity * 2);

            for (int i = 0; i < myarr.length; i++) {
                this.array[i] = myarr[i];
            }
        }

        this.array[this.count] = (T) itm;
        count ++;
    }


    public void insert(T itm, int index)
    {
        if (index >= this.count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Ошибочный индекс");
        }

        if (this.capacity < this.count + 1) {
            T[] myarr = this.array;
            makeArray(this.capacity * 2);

            for (int i = 0; i < myarr.length; i++) {
                this.array[i] = myarr[i];
            }
        }

        T[] arrtmp = (T[]) Array.newInstance(this.clazz, this.count + 1);
        System.arraycopy (this.array, 0, arrtmp, 0, index);
        arrtmp [index] =  itm;
        System.arraycopy (this.array, index, arrtmp, index+1, this.count - index);

        this.array = arrtmp;
        this.count = this.count+1;
    }

    public void remove(int index)
    {
        if (index >= this.count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Ошибочный индекс");
        }

        if ( this.count - 1 < 0.5 * this.capacity) {
            T[] myarr = this.array;

           int ncapacity = this.capacity * 2/3;

            if (ncapacity < 16) {
                ncapacity = 16;
            }
            makeArray(ncapacity);

            for (int i = 0; i < myarr.length; i++) {
                this.array[i] = myarr[i];
            }
        }


        T[] arrtmp = (T[]) Array.newInstance(this.clazz, this.count - 1);
        System.arraycopy (this.array, 0, arrtmp, 0, index);
        System.arraycopy (this.array, index+1, arrtmp, index, this.count - index-1);

        this.array = arrtmp;
        this.count = this.array.length;
    }

    public static void main(String[] args) {
    }
}