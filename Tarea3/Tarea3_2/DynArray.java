import java.lang.reflect.Array;
import java.util.*;

import java.lang.reflect.Array;
import java.util.*;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;
    int balance;
    int minsize = 16;
    int balanceplus = 3;
    int balanceminus = 2;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        balance = 3;
        makeArray(minsize);
    }

    public void makeArray (int new_capacity)//
    {
        this.array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index >= this.count)
            return null;

        return this.array[index];
    }


    public void append(T itm)
    {
        balance += balanceplus;
        isresizemas ();
        this.array[this.count] = (T) itm;
        count ++;
    }

    public void insert(T itm, int index)
    {
        if (index > this.count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Bad index");
        }
        balance += balanceplus;
        isresizemas ();

        T[] arrtmp = (T[]) Array.newInstance(this.clazz, this.capacity);
        System.arraycopy (this.array, 0, arrtmp, 0, index);
        arrtmp [index] =  itm;
        System.arraycopy (this.array, index, arrtmp, index+1, this.count - index);

        this.array = arrtmp;
        this.count = this.count+1;
    }

    public void remove(int index)
    {
        if (index >= this.count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Bad index");
        }

        T[] arrtmp = (T[]) Array.newInstance(this.clazz, this.capacity);
        System.arraycopy (this.array, 0, arrtmp, 0, index);
        System.arraycopy (this.array, index+1, arrtmp, index, this.count - index-1);

        this.array = arrtmp;
        this.count --;

        balance += balanceminus;
        isresizemenos ();
    }

    public void isresizemas () {
        if (balance >= this.minsize* 3)
            resize(true);
    }

    public void isresizemenos () {
        if ( this.count - 1 < 0.5 * this.capacity)
            resize(false);
    }


    public void  resize( boolean ismas) {
        int N, newcapacity;

        if (ismas) {
         N = this.minsize;
         newcapacity = this.capacity + minsize*2;
        }
        else {
            newcapacity = this.capacity * 2/3;
            if (newcapacity < minsize) {
                newcapacity = minsize;
            }
           N = (int)(newcapacity * 0.1);            
        }

        T[] myarr = this.array;
        makeArray (newcapacity);
        balance = balance - N;
    }


} 

