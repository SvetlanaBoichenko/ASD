import OList.OList;
import org.junit.Test;
import java.util.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PowerSet4Test {
    @Test
    public void dcart() {
        PowerSet4 pst1 = new PowerSet4();
        pst1.put("a");
        pst1.put("ana");
        pst1.put("yo");

        PowerSet4 pst2 = new PowerSet4();
        pst2.put("a");
        pst2.put("ana");
        pst2.put("y");
        pst2.put("yo");
     //   pst2.put("x");

        OList ls = PowerSet4.decart(pst1,pst2);
        Set S =  pst2.decart2(pst1,pst2);
        assertTrue(ls.count() == 9);
        ArrayList a =  ls.getAll();
    }
    @Test
    public void multis() {
        PowerSet4 pst1 = new PowerSet4();
        pst1.put("a");
        pst1.put("ana");
        pst1.put("yo");

        PowerSet4 pst2 = new PowerSet4();
        pst2.put("a");
        pst2.put("ana");
        pst2.put("y");

        PowerSet4 set2_array [] = new PowerSet4 [3];
        set2_array[0] = pst1;
        set2_array[1] = pst2;
        set2_array[2] = pst2;

        PowerSet4 pst3 =  pst2.multi_intersection( set2_array);
        boolean res = pst3.get("a");
        assertTrue(res == true);
        res = pst3.get("ana");
        assertTrue(res == true);
        res = pst3.get("y");
        assertTrue(res == false);
        res = pst3.get("yo");
        assertTrue(res == false);

    }

    @Test
    public void test1() {
        PowerSet4 pst = new PowerSet4();
        pst.put("ana");
        pst.put("yo");
        assertTrue(pst.size() == 2);
        pst.put("ana");
        assertTrue(pst.size() == 2);
        pst.put("b");
        assertTrue(pst.size() == 3);
    }
    @Test
    public void testget() {
        PowerSet4 pst = new PowerSet4();
        pst.put("ana");
        pst.put("yo");
        pst.put("a");
        pst.put("y");

        boolean res = pst.get("a");
        assertTrue(res == true);
        res = pst.get("b");
        assertTrue(res == false);
    }
    @Test
    public void testremove() {
        PowerSet4 pst = new PowerSet4();
        pst.put("ana");
        pst.put("yo");
        pst.put("a");
        pst.put("y");
        assertTrue(pst.size() == 4);
        pst.remove("y");
        assertTrue(pst.size() == 3);
        assertTrue(pst.remove("y") == false);
        assertTrue(pst.size() == 3);
        assertTrue(pst.remove("yh") == false);
        assertTrue(pst.size() == 3);
        assertTrue(pst.remove("ana") == true);
        assertTrue(pst.size() == 2);
    }

    @Test
    public void testunion() {
        PowerSet4 pst1 = new PowerSet4();
        PowerSet4 pst11 = new PowerSet4();
        PowerSet4 pst12 = pst1.union(pst11);

        pst1.put("ana");
        pst1.put("yo");
        PowerSet4 pst2 = new PowerSet4();
        pst2.put("yo");
        pst2.put("Olga");


        pst12 = pst1.union(pst11);

        pst11 = null;
        pst12 = pst1.union(pst11);


        pst12 = pst1.union(pst11);

        PowerSet4 pst3 = pst1.union(pst2);
        assertTrue(pst3.size() == 3);
        PowerSet4 pst4 = pst2.union(pst1);
        assertTrue(pst3.size() == 3);

        assertTrue(pst3.equals(pst4));
        assertTrue(pst4.equals(pst3));

        pst2.put("y1");
        pst2.put("Olga1");
        pst2.put("z");
        pst2.put("ana1");
        PowerSet4 pst5 = pst4.union(pst2);
        assertTrue(pst5.size() == 7);

        pst1.put("ana2");
        pst1.put("yo2");
        pst1.put("ana3");
        pst1.put("yo3");
        pst1.put("ana4");
        pst1.put("yo4");
        pst5 = pst1.union(pst2);
        assertTrue(pst5.size() == 13);
    }

    @Test
    public void testdiff() {
        PowerSet4 pst1 = new PowerSet4();
        pst1.put("ana");
        pst1.put("yo");
        pst1.put("tu");
        PowerSet4 pst2 = new PowerSet4();
        pst2.put("yo");
        pst2.put("ana");
        pst2.put("no");
        pst2.put("yes");
        pst2.put("yes2");

        PowerSet4 pst3 = pst1.difference(pst2);
        assertEquals(pst3.size(), 1);
        pst3 = pst2.difference(pst1);
        assertEquals(pst3.size(), 3);
    }

    @Test
    public void testesub() {
        PowerSet4 pst1 = new PowerSet4();
        pst1.put("ana");
        pst1.put("yo");
        PowerSet4 pst2 = new PowerSet4();
        pst2.put("yo");
        assertEquals(pst1.isSubset(pst2), true);
        assertEquals(pst2.isSubset(pst1), false);

        pst2.put("Olga");
        assertEquals(pst1.isSubset(pst2), false);
    }

    @Test
    public void testintersections() {
        PowerSet4 pst1 = new PowerSet4();
        pst1.put("ana");
        pst1.put("yo");
        pst1.put("juan");
        pst1.put("olga");
        pst1.put("olga2");
        PowerSet4 pst2 = new PowerSet4();
        pst2.put("olga");
        pst2.put("yo");
        pst2.put("ana");
        pst2.put("a");

        PowerSet4 pst3 = pst1.intersection(pst2);
        assertTrue(pst3.size() == 3);
        PowerSet4 pst4 = pst2.intersection(pst1);
        assertTrue(pst3.size() == 3);

        assertTrue(pst4.equals(pst3));
    }
    @Test
    public void test20000() {
        PowerSet4 pst = new PowerSet4();

        for  (int i = 0; i < 20000; i++) {
            pst.put(String.valueOf(i));
        }

        assertTrue(pst.size() == 20000);
        assertTrue(pst.get("16500") == true);
        assertTrue(pst.get("116500") == false);

        PowerSet4 pst1 = new PowerSet4();
        for  (int i = 19900; i < 20000; i++) {
            pst1.put(String.valueOf(i));
        }
        assertEquals(pst.isSubset(pst1), true);
        PowerSet4 pst2 = pst.union(pst1);
        PowerSet4 pst3 = pst1.intersection(pst2);
        assertEquals(pst3.size(), 100);

        for  (int i = 20000; i < 21000; i++) {
            pst1.put(String.valueOf(i));
        }


        PowerSet4 pst5 = pst1.intersection(pst2);
        assertEquals(pst5.size(), 100);
        PowerSet4 pst4 = pst1.difference(pst2);
        assertEquals(pst4.size(), 1000);

    }
}