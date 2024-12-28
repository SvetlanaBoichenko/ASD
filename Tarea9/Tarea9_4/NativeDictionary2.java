import java.lang.reflect.Array;
import OrderedList.*;

public class NativeDictionary2<T> {
    public int size;

    public T [] values;
    public OrderedList slots;

    public NativeDictionary2(int sz, Class clazz) {
        size = sz;
        values = (T[]) Array.newInstance(clazz, this.size);
        slots = new OrderedList(true);  //keys
    }


    public boolean setvalue (int index, T value){
        if (index >= this.values.length)
            return false;

        if (values[index] == null) {
            values[index] = value;
            return true;
        }

        int n = this.values.length;
        T tmp = values[n-1];
        int i;
        for (i = n-1; i > index; i--) {
            this.values[i] = this.values[i-1];
        }
        this.values[i] = value;
        return true;
    }


    public void put (String key, T value)
    {                      // Add value to key
        this.slots.add (key);
        int index = this.slots.getkeyindex (key);
        this.setvalue(index, value);
    }


    public T get (String key)
    {                      // return value for key or null
        int index = this.slots.getkeyindex(key);

        if (index >=0) {
            return (this.values[index]);
        }
        return null;
    }

    
    public boolean isKey(String key)
    {
        return (this.slots.getkeyindex(key) >= 0);
    }



    public static void main(String[] args) {
        NativeDictionary2 <Integer> nd2 = new NativeDictionary2 <>(5, Integer.class);
        Integer val = 0;
        nd2.put ("A", val);

        int comp = 0;
        comp = "Ana".compareTo("A");
        System.out.println( comp);
    }

}