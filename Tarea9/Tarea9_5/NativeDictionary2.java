import java.lang.reflect.Array;
import OrderedList.*;

public class NativeDictionary2<T> {
    public int size;

    public T [] values;
    public OrderedList slots;
    int count;
    public NativeDictionary2(int sz, Class clazz) {
        size = sz;
        values = (T[]) Array.newInstance(clazz, this.size);
        slots = new OrderedList(true);  //keys
        count = 0;
    }


    public int setvalue (T value){
        int index = count;
        if (index < this.size) {
            values[index] = value;
            count ++;
            return index;
        }
        return -1;
    }


    public void put (String key, T value)
    {                      // Add value to key
       int index = this.setvalue(value);
       if (index >= 0)
            this.slots.add (key, index);
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