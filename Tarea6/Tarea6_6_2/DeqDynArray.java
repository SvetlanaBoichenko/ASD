import java.lang.reflect.Array;

public class DeqDynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;
    static int reqsize = 16;

    int eindex;
    int findex;
    public DeqDynArray(Class clz) {
        clazz = clz;
        count = 0;
        findex =  reqsize / 3;
        eindex = findex+1;
        makeArray(reqsize);
    }

    public void makeArray (int new_capacity) {
        this.array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
    }

    public void append(T itm) {
        if (this.capacity <= this.count+this.findex + 1) {
            T[] myarr = this.array;
            makeArray(this.capacity * 2);

            int fi = this.findex;
          //  this.findex = this.capacity/3;
            for (int i = this.findex; i < myarr.length; i++) {
                this.array[i] = myarr[i];

            }
        }

        this.array[this.eindex] = (T) itm;
        count ++;
        this.eindex++;
    }

    public void appendF(T itm) {
        int fi = 0;
        if (this.findex <= 1) {
            T[] myarr = this.array;
            makeArray(this.capacity * 2);

            fi = this.findex;
            this.findex = this.capacity / 3;
            this.eindex += (this.findex-fi);

            for (int i = this.findex; i < myarr.length + this.findex - 1; i++) {
                this.array[i] = myarr[fi];
                fi++;
            }
        }
        this.array[this.findex] = (T) itm;

        this.count ++;
        this.findex--;
    }


    public void remove () {
        if (this.eindex >= this.capacity || this.eindex < 0) {
            throw new ArrayIndexOutOfBoundsException("Bad index");
        }

        if ( this.count+this.findex - 1 < 0.5 * this.capacity) {
            T[] myarr = this.array;

            int ncapacity = this.capacity * 2/3;
            if (ncapacity < reqsize) {
                ncapacity = reqsize;
            }
            makeArray(ncapacity);

            int fi = this.findex;

            for (int i = this.findex; i < this.capacity-1; i++) {
                this.array[i] = myarr[fi];
                fi++;
            }
        }
        this.array[eindex] = null;
        this.count --;
        eindex--;
    }

    public void removeF() {
        if (this.findex >= this.count || this.findex < 0) {
            throw new ArrayIndexOutOfBoundsException("Bad index");
        }

        if ( this.findex - 1 > 0.5 * this.capacity) {
            T[] myarr = this.array;

            int ncapacity = this.capacity * 2/3;

            if (ncapacity < reqsize) {
                ncapacity = reqsize;
            }
            makeArray(ncapacity);

            int fi = this.findex;
            this.findex = this.capacity/3;
            this.eindex += (this.findex-fi);

            for (int i = this.findex; i < ncapacity; i++) {
                this.array[i] = myarr[fi];
                fi++;
            }
        }

        this.array[findex] = null;
        this.findex--;
        this.count --;
    }

    

}


