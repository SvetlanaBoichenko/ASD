
import java.lang.reflect.Array;
import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedListArr<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;
    private boolean _ascending;// voshod

    public OrderedListArr(Class clz, boolean asc)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
        _ascending = asc;
    }

     public void makeArray (int new_capacity)//
     {
        this.array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
     }

    public int compare(T v1, T v2)
    {
        int ret = 0;
        Class<?> cls = v1.getClass();
        if(cls.getName().equals("java.lang.Integer")) {
            ret = ((Integer) v1).compareTo((Integer) v2);
        }
        if ((cls.getName().equals("java.lang.String"))){
            ret = ((String) v1).compareTo((String) v2);
        }
        if (ret > 0)
            return 1;
        if (ret < 0)
            return -1;

        return 0;
    }


    public void add(T value) {
        if (this.array[0] == null) {
            this.array[0] = value;
            this.count++;
            return;
        }
        int ascendval = -1;
        if (this._ascending) {
            ascendval = 1;
        }
        int index;
        for (index = 0; index < this.count; index++) {
            if (this.array[index] != null && (this.compare(value, this.array[index])) != ascendval) {
                break;
            }
        }

        if (this.capacity < this.count + 1) {
            T[] myarr = this.array;
            makeArray(this.capacity * 2);

            for (int i = 0; i < myarr.length; i++) {
                this.array[i] = myarr[i];
            }
        }
        T[] arrtmp = (T[]) Array.newInstance(this.clazz, this.capacity);
        System.arraycopy (this.array, 0, arrtmp, 0, index);
        arrtmp [index] =  value;
        System.arraycopy (this.array, index, arrtmp, index+1, this.count - index);

        this.array = arrtmp;
        this.count = this.count+1;
    }



    public int find(T val)
    {
        int newpos;
        T before = null, after = null;
        int lpos = 0, rpos = this.count-1;;

        while (lpos <= rpos) {

            newpos = (lpos+ rpos) / 2;

            if (this.compare(val, this.array[newpos]) == 0)
                return newpos;

            if ((this.compare(val, this.array[newpos]) == 1 && _ascending)||
            (this.compare(val, this.array[newpos]) == -1 && !_ascending)){
                lpos = newpos + 1;
            }
            if ((this.compare(val, this.array[newpos]) == -1 && _ascending) ||
                    (this.compare(val, this.array[newpos]) == 1 && !_ascending))
                rpos = newpos - 1;
            }
        return -1; //
    }


    public void delete(T val)
    {
       int val_index = this.find(val);

       if (val_index >= this.count || val_index < 0) {
            throw new ArrayIndexOutOfBoundsException("Bad index");
        }

        if ( this.count - 1 < 0.5 * this.capacity) {
            T[] myarr = this.array;

            int ncapacity = this.capacity * 2/3;

            if (ncapacity < 16) {
                ncapacity = 16;
            }
            makeArray(ncapacity);

            for (int i = 0; i < ncapacity; i++) {
                this.array[i] = myarr[i];
            }
        }

        T[] arrtmp = (T[]) Array.newInstance(this.clazz, this.capacity);
        System.arraycopy (this.array, 0, arrtmp, 0, val_index);
        System.arraycopy (this.array, val_index+1, arrtmp, val_index, this.count - val_index-1);

        this.array = arrtmp;
        this.count --;
    }


    public void clear(boolean asc)
    {
       for (int i = 0; i < this.count; i++) {
            this.array[i] = null;
        }
       this.count = 0;
        makeArray(16);

        _ascending = asc;
    }

    public int count()
    {
        int n = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == null)
                break;
            n++;
        }
        return n;
    }


public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}