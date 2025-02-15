import java.util.*;

public class PowerSet
{
    Hashtable <String, Integer> ptab;

    public PowerSet4() {
        this.ptab = new Hashtable <>(); // your realisation the powerset
    }

    public int size() {
        return this.ptab.size();   // 
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

    public PowerSet4 intersection(PowerSet4 set2) {
        PowerSet4 res = new PowerSet4();
        for (String key : set2.ptab.keySet() ){
            if (this.get(key)){
                res.put(key);
            }
        }
        return (res);
    }

    public PowerSet4 union(PowerSet4 set2) {
        if (set2 == null) {
            return null;
        }
        PowerSet4 res = new PowerSet4();
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

    public PowerSet4 difference(PowerSet4 set2)
    {
        if (set2 == null) {
            return null;
        }
        PowerSet4 res = new PowerSet4();

        for (String key : this.ptab.keySet() ){
            if (! set2.get(key)){
                res.put(key);
            }
        }
        return (res); //
    }

    public boolean isSubset(PowerSet4 set2) {
        if (set2 == null) {
            return false;
        }

        for (String key : set2.ptab.keySet()) {
            if (!this.get(key)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(PowerSet4 set2)// <T>
    {
        if (set2 == null) {
            return false;
        }
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
