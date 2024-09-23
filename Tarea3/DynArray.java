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
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }
   
    public void makeArray (int new_capacity)// new capacity - занять память
    {   //array = (T[]) Array.newInstance(this.clazz, new_capacity);
        int req_capacity = this.capacity;

        if (this.capacity == 0) {
            this.capacity = 16;
            this.array = (T[]) new Integer [16];
            return;
        }

        boolean f = false;

        if (new_capacity < 16) {
            req_capacity = 16;
            f = true;
        }

        int old_capacity = this.capacity;
        // Low
        while (new_capacity < this.capacity & f ==  false) {
            req_capacity = req_capacity * 2 / 3;
            if (new_capacity >= req_capacity) {
                req_capacity = old_capacity;
                f = true;
                break;
            }
            old_capacity  = req_capacity;
        }
        // Up
        while (new_capacity >  req_capacity & f ==  false) {
                req_capacity *= 2;  //
        }

        new_capacity = req_capacity;
        Integer [] myarr = new Integer [new_capacity];

        System.arraycopy(this.array, 0,  myarr, 0, this.count);
        this.capacity = new_capacity;
        this.array = (T[]) myarr;
    }


    public T getItem(int index)
    {
        if (index >= this.count)
            return null;

        return this.array[index];
    }


    public void append(T itm)
    {
      int n = this.count;

      if (this.capacity <= count) {
          makeArray(count + 1);
      }
        Integer itm1 = (Integer) itm;
        this.array[n] = (T) itm1;
        count++;
    }

    public void insert(T itm, int index)
    {
      if (index >= this.count)
          return;
        Integer [] arrtmp = new Integer [this.count + 1];
        System.arraycopy (this.array, 0, arrtmp, 0, index);
        arrtmp [index] = (Integer) itm;
        System.arraycopy (this.array, index, arrtmp, index+1, this.count - index);

      if (arrtmp.length > this.capacity)
        makeArray (arrtmp.length);

        this.array = (T[])arrtmp;
        this.count = this.array.length;
    }

    public void remove(int index)
    {
        if(index >= this.count) {
            return;
        }

        Integer [] arrtmp = new Integer [this.count - 1];
        System.arraycopy (this.array, 0, arrtmp, 0, index);

        System.arraycopy (this.array, index+1, arrtmp, index, this.count - index-1);

        if ( arrtmp.length < this.capacity / 2)
            makeArray (arrtmp.length);

        this.array = (T[])arrtmp;
        this.count = this.array.length;
    }


    
} 



