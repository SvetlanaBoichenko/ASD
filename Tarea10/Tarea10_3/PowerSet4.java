import java.util.*;
import OList.*;

public class PowerSet4
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

    //----------------------------------------

    static public OList decart(PowerSet4 set1,PowerSet4 set2)
    {
        OList cortlist = new OList();
        PowerSet4 strlist = new PowerSet4();
        String tmpstr = null;

        String [] sarray = new String[set1.size() + set2.size()];
        int i = 0;
        for (String key1 : set1.ptab.keySet())  {
            sarray[i] = key1;
            i++;
        }
        for (String key2 : set2.ptab.keySet())  {
            sarray[i] = key2;
            i++;
        }

        Arrays.sort(sarray);

        for (int j = 0; j < sarray.length -1; j++) {
            for (int k = j+1; k < sarray.length; k++) {
                 String skey1 = sarray[j];
                 String skey2 = sarray[k];

                if (skey1.compareTo(skey2) <= 0) {
                   tmpstr = skey1 + "," + skey2;
                }
                else {
                   tmpstr = skey2 + "," + skey1;
                }

                if (strlist.get(tmpstr) == false ) {
                    cortlist.add(skey1, skey2);
                    strlist.put(tmpstr);
                }
            }
        }
        return cortlist;
    }

    //-----------------------------------------------------
    static public PowerSet4 multi_intersection(PowerSet4 [] set2_array)
    {
        PowerSet4 res = new PowerSet4().union(set2_array[0]);

        for (PowerSet4 set2: set2_array)
            res = res.intersection(set2);

        return res;
    }

    public static void main(String[] args) {};
}