
public class DynHashArray
{
    public String [] array;
    public int count;
    public int capacity;
    int step;
    public DynHashArray() //Class clz)
    {
        count = 0;
        step = 1;
        makeArray(17);
    }

    public void makeArray (int new_capacity)//
    {
        this.array = new String [new_capacity];
        this.capacity = new_capacity;
    }

    public String getItem(int index)
    {
        if (index >= this.count)
            return null;
        return this.array[index];
    }

    public int find(String value)
    {
       int ind = this.hashFun(value);

       for (int i = 0; i < this.capacity; i++) {
           if (this.array[ind] == null)
               return -1;

            if (this.array[ind].equals(value) ) {
                return ind;
            }
            ind = (ind + this.step) % this.capacity;
        }
        return -1;
    }

    public void put(String itm)
    {
        int index = this.seekSlot(itm);

        if (index < 0) {
            String[] myarr = this.array;
            makeArray(this.capacity * 2 + 7);

            for (int i = 0; i < myarr.length; i++) {
                int ind = this.seekSlot(myarr[i]);
                this.array[ind] = myarr[i];
            }
            index = this.seekSlot(itm);
        }
        this.array[index] =  itm;
        count ++;
    }

    public void remove(String value)
    {
        int index = this.hashFun(value);
        if (index >= 0) {
            this.array[index] = null;
        }
        this.count--;

        if ( this.count - 1 < 0.5 * this.capacity) {
            String[] myarr = this.array;
            int oldcapacity = this.capacity;
            int ncapacity = this.capacity * 2/3;
            if (ncapacity < 16) {
                ncapacity = 16;
            }
            makeArray(ncapacity);

            for (int i = 0; i < oldcapacity; i++) {
                if (myarr[i] != null){
                    int ind = this.seekSlot(myarr[i]);
                    this.array[ind] = myarr[i];
                }
            }
        }
    }

    public int hashFun (String value) {
        if (value.equals(""))
            return 0;

        int ind = 0;
        for ( int i = 0; i< value.length(); i++) {
            ind = ind + (int)(value.charAt(i));
        }
        return (ind % this.capacity);
    }

    public int seekSlot(String value) {
        int ind = this.hashFun(value);

        for (int i = 0; i < this.capacity; i++) {
            if (this.array[ind] == null) {
             //   this.array[ind] = value;
                return ind;
            }
            ind = (ind + this.step) % this.capacity;  //size
        }
        return -1;
    }


}

