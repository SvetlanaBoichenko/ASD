import java.lang.reflect.Array;
import java.util.Objects;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;// keys
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
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
        ind = ind % this.size;
        return ind;
    }

    public boolean isKey(String key)
    {// return true if thereis the key int the Dict
       int ind = this.hashFun(key);// int value of the String key-element of Slots
        int i = ind;

        while (this.slots[i] != null && this.slots[i] != key) {
            i = (i + 1) % this.size;
            if (i == ind)
                return false;
        }
            if (Objects.equals(slots[ind], key))
            return true;

            return false;
    }

    public void put(String key, T value)
    {  // Add value to key
        int index = this.hashFun(key);
        this.slots[index] = key;
        this.values[index] =  value;
    }

    public T get(String key)
    {// return value for key or null
        int index = this.hashFun(key);

        return  (this.values[index]);
        //return null;
    }

    public static void main(String[] args) {

    }
}