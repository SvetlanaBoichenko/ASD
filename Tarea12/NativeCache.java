import java.lang.reflect.Array;

public class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    { // return real index of slot
        if (key.equals(""))
            return 0;

        int ind = 0;
        for ( int i = 0; i< key.length(); i++) {
            ind = ind + (int)(key.charAt(i));
        }
        ind = ind % this.size;
        return ind;
    }

    public int rindex (String key){   //real index for same hash & dif key
        int first_index = this.hashFun(key);
        int i = first_index;
      //  while (this.slots[i] != null && this.slots[i] != key)
        for (int x = i; x < this.slots.length; x++) {
            if (this.slots[i] == null || this.slots[i] == key) {
                return i;
            }
            i = (i + 1) % this.size;
            if (i == first_index) // stop cicle
                return -1;
        }
        return -1;
    }

    public int indbadvalue() {
        int m = 0;
        int i;
        int min = hits[0];

        for (i = 1; i < hits.length; i++) {
            if (hits[i] < min) {
                min = hits[i];
                m = i;
            }
        }
        return m;
    }

    public void put(String key, T value)
    {  // Add value to key
        int index = this.rindex(key);

        if (index < 0) {            //There is not libres places
            index = indbadvalue();   // ret less used index
            this.hits[index] = 0;
        }
        this.slots[index] = key;    // occupe less used cell
        this.values[index] =  value;
        this.hits[index] += 1;
    }

    public T get(String key)
    {   // return value for key or null
        int index = this.rindex(key);
        if (index >= 0 && this.values[index] != null) {
            this.hits[index] += 1;
            return (this.values[index]);
        }
        return null;
    }

   
} 


