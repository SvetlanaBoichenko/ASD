import java.lang.reflect.Array;
import java.util.*;


public class NativeDictionary2<T> {
    public int size;
    // public String[] slots;// keys
    public T [] values;
    public OrderedList slots;
    ;// keys

    public NativeDictionary2(int sz, Class clazz) {
        size = sz;
        values = (T[]) Array.newInstance(clazz, this.size);
        slots = new OrderedList(true);  //keys
    }

    public boolean isKey(String key)
    {
        return (this.slots.getkeyindex(key) >= 0);
    }

    public boolean setvalue (int index, T value){
        if(index >= this.values.length)
            return false;

        if (values[index] == null) {
            values[index] = value;
            return true;
        }
        T val = values[index];
        values[index] = value;
        for (int i = index+1; i < this.values.length - 1; i++) {
            this.values[i] = val;
            val = this.values[i+1];
        }
        return true;
    }

    public void put (String key, T value)
    {                      // Add value to key
      int index = this.slots.add (key);
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

    public static void main(String[] args) {
        String str2 = "Ana1!";
        String str3 = "Ana2333";
        int result = str2.compareTo(str2);
        System.out.println(result);
        result = str2.compareTo(str3);
        System.out.println(result);
        result = str3.compareTo(str2);
        System.out.println(result);

    }


    class Node  {
        public String value;
        public Node next, prev;

        public Node(String _value) {
            value = _value;
            next = null;
            prev = null;
        }
    }


    class OrderedList<T extends Comparable> {
        public Node head, tail;
        private boolean _ascending;// voshod

        public OrderedList(boolean asc) {
            head = null;
            tail = null;
            _ascending = asc;
        }

        public int size()
        {   int s = 0;
            if(this.head == null)
                return 0;

            if(this.head == this.tail)
                return 1;

            for (Node n = this.head; n != this.tail; n = n.next) {
                s++;
            }
            return s;
        }

        public int add(String value)
        {
            Node newnod = new Node(value);
            Node curnod = this.head;

            if (curnod == null) {
                this.head = newnod;
                this.tail = head; //??
                return 0;
            }
            int ascendval = -1;
            if (this._ascending) {
                ascendval = 1;
            }
            int i;
            for (i = 0; i < this.size(); i++) {

                if (curnod == null | newnod.value.compareTo(curnod.value) != ascendval) {
                    break;
                }
                curnod = curnod.next;
            }

            if (curnod == null) {
                this.tail.next = newnod;
                newnod.prev = this.tail;
                this.tail = newnod;
                return i;
            }
            if (curnod == this.head) {
                newnod.next = this.head;
                this.head.prev = newnod;
                this.head = newnod;
                return 1;
            }
            if (curnod == this.tail) {
                newnod.next = this.tail;
                newnod.prev = this.tail.prev;
                this.tail.prev.next = newnod;
                this.tail.prev = newnod;
                return i+1;
            }
            curnod.prev.next = newnod;
            newnod.next = curnod;
            newnod.prev = curnod.prev;
            curnod.prev = newnod;
            return i;
        }


        public int getkeyindex (String  value) {
            Node curnod = this.head;

            for (int i = 0; i < this.size(); i++) {
                if (curnod.value.equals(value)) {
                   return i;
                }
                curnod = curnod.next;
            }
            return -1;
        }
    }
}

