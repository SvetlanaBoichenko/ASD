import java.lang.reflect.Array;
import java.util.Objects;



class NativeDictionary2n <T>
{
    static int sz = 32;
    public int size;
    public String [] slots;// keys
    public T [] values;

    public NativeDictionary2n(Class clazz)
    {
        size = sz;
        slots = new String[size];
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
        //    ind = ind % this.size;
        ind = ind & (this.size - 1);
        return ind;
    }

    public int rindex (String key){   //real index for same hash & dif key
        int first_index = this.hashFun(key);
        int i = first_index;
        while (this.slots[i] != null && this.slots[i] != key) {
            i = (i + 1) % this.size;
            if (i == first_index) // stop cicle
                return -1;
        }
        return i;
    }

    public boolean isKey(String key)
    {                                // return true if thereis the key int the Dict
        int ind = this.rindex(key);  // int value of the String key-element of Slots

        if (ind >= 0 && Objects.equals(slots[ind], key)) {
            return true;
        }
        return false;
    }

    public void put(String key, T value)
    {  // Add value to key
        int index = this.rindex(key);
        this.slots[index] = key;
        this.values[index] =  value;
    }

    public T get(String key)
    {// return value for key or null
        int index = this.rindex(key);
        if (index >= 0) {
            return (this.values[index]);
        }
        return null;
    }
public static void main(String[] args) {}
}

