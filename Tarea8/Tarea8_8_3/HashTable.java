import java.util.*;

public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        if (value.equals(""))
            return 0;

        int ret = 0;
        for ( int i = 0; i< value.length(); i++) {
            ret = ret + (int)(value.charAt(i));
        }

        ret = ret % this.size;
        return ret;
    }

    public int seekSlot(String value)
    {
        int ind = this.hashFun(value);

        int find = ind;
        String slotvale = this.slots[ind];
        while ( this.slots[ind] != null && !value.equals(slotvale)) {
            ind = (ind + this.step) % this.size;
            if (ind == find)
                return -1;
        }
        return ind;
    }

    public int put(String value)
    {
        int ind = this.seekSlot(value);
        if (ind != -1)
            this.slots[ind] = value;

        return ind;
    }

    public int find(String value)
    {
        int ind = this.hashFun(value);
        int find = ind;

        while (this.slots[ind] != value) {
            ind = (ind + this.step) % this.size;

            if (ind == find)
                return -1;
        }
        return ind;
    }

//---------------зад 5 dd-----------------------
    public void dd (){
        Random rnd = new Random();
        int first = 97;         // ascii
        int last = first+2+this.size/10;
        if ((last) > 255 )
            last = 255;

        for (int i = 0; i < this.size+100; i++) {
            this.put(rnd.ints(last-first+1, first, last).collect(StringBuilder::new, StringBuilder::appendCodePoint,
                    StringBuilder::append).toString());
        }

        for (int i = 0; i < this.size*100; i++) {
            this.put(rnd.ints(1, 1,this.size*10).collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append).toString());
            }
    }

//----------Hash + Sal----------
    public int ShashFun(String value)
    {
        if (value.equals(""))
            return 0;

        int ret = 0;
        for ( int i = 0; i< value.length(); i++) {
           ret = ret + (int)(value.charAt(i)) + (int)Math.sqrt((int)(value.charAt(i)));
        }

        ret = ret % this.size;
        return ret;
    }

    public int seekSlotS(String value)
    {
        int ind = this.ShashFun(value);

        int find = ind;
        String slotvale = this.slots[ind];
        while ( this.slots[ind] != null && !value.equals(slotvale)) {
            ind = (ind + this.step) % this.size;
            if (ind == find)
                return -1;
        }
        return ind;
    }

    public int putS(String value)
    {
        int ind = this.seekSlotS(value);
        if (ind != -1)
            this.slots[ind] = value;

        return ind;
    }
    public int findS(String value)
    {
        int ind = this.ShashFun(value);
        int find = ind;

        while (this.slots[ind] != value) {
            ind = (ind + this.step) % this.size;

            if (ind == find)
                return -1;
        }
        return ind;
    }


} 

