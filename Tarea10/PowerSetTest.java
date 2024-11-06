import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PowerSetTest {
    @Test
    public void test1() {
        PowerSet pst = new PowerSet();
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
        PowerSet pst = new PowerSet();
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
        PowerSet pst = new PowerSet();
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
        PowerSet pst1 = new PowerSet();
        PowerSet pst11 = new PowerSet();
        PowerSet pst12 = pst1.union(pst11);

        pst1.put("ana");
        pst1.put("yo");
        PowerSet pst2 = new PowerSet();
        pst2.put("yo");
        pst2.put("Olga");


        pst12 = pst1.union(pst11);

        pst11 = null;
        pst12 = pst1.union(pst11);


         pst12 = pst1.union(pst11);

        PowerSet pst3 = pst1.union(pst2);
        assertTrue(pst3.size() == 3);
        PowerSet pst4 = pst2.union(pst1);
        assertTrue(pst3.size() == 3);

        assertTrue(pst3.equals(pst4));
        assertTrue(pst4.equals(pst3));

        pst2.put("y1");
        pst2.put("Olga1");
        pst2.put("z");
        pst2.put("ana1");
        PowerSet pst5 = pst4.union(pst2);
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
        PowerSet pst1 = new PowerSet();
        pst1.put("ana");
        pst1.put("yo");
        pst1.put("tu");
        PowerSet pst2 = new PowerSet();
        pst2.put("yo");
        pst2.put("ana");
        pst2.put("no");
        pst2.put("yes");
        pst2.put("yes2");

        PowerSet pst3 = pst1.difference(pst2);
        assertEquals(pst3.size(), 1);
        pst3 = pst2.difference(pst1);
        assertEquals(pst3.size(), 3);
    }

    @Test
    public void testesub() {
        PowerSet pst1 = new PowerSet();
        pst1.put("ana");
        pst1.put("yo");
        PowerSet pst2 = new PowerSet();
        pst2.put("yo");
        assertEquals(pst1.isSubset(pst2), true);
        assertEquals(pst2.isSubset(pst1), false);

        pst2.put("Olga");
        assertEquals(pst1.isSubset(pst2), false);
    }

    @Test
    public void testintersections() {
        PowerSet pst1 = new PowerSet();
        pst1.put("ana");
        pst1.put("yo");
        pst1.put("juan");
        pst1.put("olga");
        pst1.put("olga2");
        PowerSet pst2 = new PowerSet();
        pst2.put("olga");
        pst2.put("yo");
        pst2.put("ana");
        pst2.put("a");

        PowerSet pst3 = pst1.intersection(pst2);
        assertTrue(pst3.size() == 3);
        PowerSet pst4 = pst2.intersection(pst1);
        assertTrue(pst3.size() == 3);

        assertTrue(pst4.equals(pst3));
    }
    @Test
    public void test20000() {
        PowerSet pst = new PowerSet();

        for  (int i = 0; i < 20000; i++) {
            pst.put(String.valueOf(i));
        }

        assertTrue(pst.size() == 20000);
        assertTrue(pst.get("16500") == true);
        assertTrue(pst.get("116500") == false);

        PowerSet pst1 = new PowerSet();
        for  (int i = 19900; i < 20000; i++) {
            pst1.put(String.valueOf(i));
        }
        assertEquals(pst.isSubset(pst1), true);
        PowerSet pst2 = pst.union(pst1);
        PowerSet pst3 = pst1.intersection(pst2);
        assertEquals(pst3.size(), 100);

        for  (int i = 20000; i < 21000; i++) {
            pst1.put(String.valueOf(i));
        }


        PowerSet pst5 = pst1.intersection(pst2);
        assertEquals(pst5.size(), 100);
        PowerSet pst4 = pst1.difference(pst2);
        assertEquals(pst4.size(), 1000);

    }
}
