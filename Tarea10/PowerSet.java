import java.util.*;

public class PowerSet
{
    Hashtable <String, Integer> ptab;
   // Hashtable <T, T> ptab2;
    public PowerSet() {
        this.ptab = new Hashtable <>(); // ваша реализация хранилища
    }

    public int size() {
        return this.ptab.size();   // количество элементов в множестве
    }

    public void put(String value) {
        this.ptab.put(value, 1);// key, value = 1;
        // всегда срабатывает
    }

    public boolean get(String value) {
        if (this.ptab.get(value) != null)
            return true;
        // возвращает true если value имеется в множестве, // иначе false
        return false;
    }

    public boolean remove(String value) {
        if (this.get(value) == false)
            return false;
        Integer res = this.ptab.remove(value);
        return (this.ptab.get(value) == null);
        // возвращает true если value удалено// иначе false
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet res = new PowerSet();
        for (String key : set2.ptab.keySet() ){
            if (this.get(key)){
                res.put(key);
            }
        }          // пересечение текущего множества и set2
        return (res);
    }

    public PowerSet union(PowerSet set2) {
        if (this.ptab.size() == 0 && set2.ptab.size() == 0){
            // объединение текущего множества и set2
            return null;
        }
        PowerSet res = new PowerSet();
        for (String key : this.ptab.keySet()) {
            if (!set2.get(key)) {
                res.put(key);
            }
        }
     //   for (String key : set2.ptab.keySet()) {
     //       if (!this.get(key)) {
      //          res.put(key);
      //      }
      //  }
       for (String key : set2.ptab.keySet()){
           res.put(key);
       }
       return res;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        boolean f = false;
     //   for (String key : set2.ptab.keySet() ){
     //       if (! this.get(key)){
     //           f = true;
     //           res.put(key);
      //      }
      //  }          // пересечение текущего множества и set2
        for (String key : this.ptab.keySet() ){
            if (! set2.get(key)){
                f = true;
                res.put(key);
            }
        }

        if (!f)
            res = null;
        return (res); // разница текущего множества и set2
    }

    public boolean isSubset(PowerSet set2) {
        for (String key : set2.ptab.keySet()) {
            if (!this.get(key)) {
                return false;
            }
            // возвращает true, если set2 есть// подмножество текущего множества,// иначе false
        }
        return true;
    }

    public boolean equals(PowerSet set2)// <T>
    {
        if (set2.size() != this.size())
            return false;
        for (String key : set2.ptab.keySet()) {
            if (!this.get(key)) {
                return false;
            }
            // возвращает true,// если set2 равно текущему множеству,// иначе false
        }
        return true;
    }

        public static void main(String[] args) {}
}