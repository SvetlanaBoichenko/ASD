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

    public int seekSlot(String value) {
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

    public int put(String value) {
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
//-------------------------------------------------------------
    public int hashFun(String value) {
    if (value.equals(""))
        return 0;

        int ind = 0;
        for ( int i = 0; i< value.length(); i++) {
            ind = ind + (int)(value.charAt(i));
        }

        return (ind % this.size);
    }

    static double Z = 0.618;
    public int hashFun2 (String key){

    int key2 = 0;
    for ( int i = 0; i< key.length(); i++) {
        key2 = key2 + (int)(key.charAt(i));
    }

    float f = (float) (key2 * Z) % 1;           //
    key2 = (int)(f * this.size);

    return key2;
}

    public int put2(String value)
    {
        int ind = this.hashFun(value);

        for (int i = 0; i< this.size; i++){
            ind = (ind + i* this.hashFun2(value))% this.size;
            if (this.slots[ind] == null) {
                this.slots[ind] = value;
                    return ind;
            }
        }
        return -1;
    }
//---------------------------------------------------------

    public static void main(String[] args) {}
}