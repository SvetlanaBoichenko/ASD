import java.util.*;

public class PowerSet
{
    Hashtable <String, Integer> ptab;

    public PowerSet() {
        this.ptab = new Hashtable <>(); //
    }

    public int size() {
        return (this.ptab.size());   // количество разных эл
    }

    public int card() {
        int n = 0;   // количество всех эл
        for (String key : this.ptab.keySet() ){
                n += getvalue(key);
        }
        return n;
    }

    public void put (String value) {
       if (this.get(value) == false) {      // val == null
           this.ptab.put(value, 1);         // key, value = 1;
            return;
       }
        int val = this.getvalue(value); //val-is value of the key
        this.ptab.put(value, val+1);    // val != null
    }


    public boolean get(String value) {
        return (this.ptab.get(value) != null);
    }

    public int getvalue(String value) {
        return (this.ptab.get(value) );
    }


    public boolean remove(String value) {
        if (this.get(value) == false)
            return false;
        Integer res = this.ptab.remove(value);
        return (this.ptab.get(value) == null);
    }

    public boolean remove1el(String value) {
        if (this.get(value) == false)
            return false;
        int nelements = this.getvalue(value);// value - is the key here

        if (nelements == 1) {
            Integer res = this.ptab.remove(value);
            return (this.ptab.get(value) == null);
        }
        this.ptab.put(value, nelements-1);
        return true;
    }

    public static void main(String[] args) { }
}

//6.* (бонус +500) Реализуйте мульти-множество (Bag),
// в котором каждый элемент может присутствовать несколько раз.
// Добавьте методы добавления элементов, удаления одного экземпляра элемента
// и получения списка всех элементов с их частотами (сколько раз встречаются).