import java.lang.reflect.Array;
import java.util.Objects;

class NativeDictionary2n <T>
{
    static int sz = 32;
    public int size;
    public Integer [] slots;// String keys
    public T [] values;

    public NativeDictionary2n(Class clazz)
    {
        size = sz;
        slots = new Integer [size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }
    
    public int hashFun(Integer key)
    { // return real index of slot
        if (key == null)
            return -1;

        key = key & (this.size - 1);
        return key;
    }

    public int rindex (Integer key){   //real index for same hash & dif key
        int first_index = this.hashFun(key);
        
        int i = first_index;
        while (this.slots[i] != null && this.slots[i] != key) {
            i = (i + 1) % this.size;
            if (i == first_index) // stop cicle
                return -1;
        }
        return i;
    }

    public boolean isKey(Integer key)
    {
        int ind = this.rindex(key);  //
        return (ind >= 0 && Objects.equals(slots[ind], key));
    }

    public void put(Integer key, T value)
    {  // Add value to key
        int index = this.rindex(key);
        this.slots[index] = key;
        this.values[index] =  value;
    }

    public T get(Integer key)
    {// return value for key or null
        int index = this.rindex(key);
        if (index >= 0) {
            return (this.values[index]);
        }
        return null;
    }

    
    }



