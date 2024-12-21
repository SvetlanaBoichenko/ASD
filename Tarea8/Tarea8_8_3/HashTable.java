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
        for (int i = 0; i < this.size*600; i+= 3) {
            if (i%2 != 0){
                this.put (String.valueOf(i));
                this.put (String.valueOf(i+1));
                this.put (String.valueOf(i+2));
                this.put (String.valueOf(i+3));
                this.put (String.valueOf(i+4));
            }
            else
                this.put (String.valueOf(i*300));
                this.put (String.valueOf(i*2));

                this.put (String.valueOf((i+1)*300));
                this.put (String.valueOf((i+1)*2));
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

