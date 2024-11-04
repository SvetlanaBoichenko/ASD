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
       
    }

    public boolean get(String value) {
        if (this.ptab.get(value) != null)
            return true;
      
        return false;
    }

    public boolean remove(String value) {
        if (this.get(value) == false)
            return false;
        Integer res = this.ptab.remove(value);
        return (this.ptab.get(value) == null);
       
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet res = new PowerSet();
        for (String key : set2.ptab.keySet() ){
            if (this.get(key)){
                res.put(key);
            }
        }         
        return (res);
    }

    public PowerSet union(PowerSet set2) {
        if (this.ptab.size() == 0 && set2.ptab.size() == 0){
         
            return null;
        }
        PowerSet res = new PowerSet();
        for (String key : this.ptab.keySet()) {
            if (!set2.get(key)) {
                res.put(key);
            }
        }
    
       for (String key : set2.ptab.keySet()){
           res.put(key);
       }
       return res;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        boolean f = false;
   
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
    
        }
        return true;
    }

     
}


