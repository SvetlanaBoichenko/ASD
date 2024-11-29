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
        pst.put("ana");
        pst.put("ana");
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
        pst.put("ana");
        pst.put("ana");
        assertTrue(pst.size() == 4);
        assertTrue(pst.card() == 6);
        assertTrue(pst.getvalue("ana") == 3);

        pst.remove1el("ana");
        assertTrue(pst.card() == 5);
        assertTrue(pst.getvalue("ana") == 2);
        pst.remove("y");
        assertTrue(pst.size() == 3);
        assertTrue(pst.remove("y") == false);
        assertTrue(pst.size() == 3);
        assertTrue(pst.remove("yh") == false);
        assertTrue(pst.size() == 3);
        assertTrue(pst.remove("ana") == true);
        pst.remove1el("a");
        assertTrue(pst.remove1el("a")== false);
        assertTrue(pst.size() == 1);
    }

    @Test
    public void test20000() {
        PowerSet pst = new PowerSet();

        for  (int i = 0; i < 10000; i++) {
            pst.put(String.valueOf(i));
        }
        for  (int i = 0; i < 10000; i++) {
            pst.put(String.valueOf(i));
        }

        assertTrue(pst.size() == 10000);
        assertTrue(pst.get("6500") == true);
        assertTrue(pst.get("116500") == false);

        PowerSet pst1 = new PowerSet();
        for  (int i = 19900; i < 20000; i++) {
            pst1.put(String.valueOf(i));
        }

        for  (int i = 20000; i < 21000; i++) {
            pst1.put(String.valueOf(i));
        }
        for  (int i = 20000; i < 21000; i++) {
            pst1.put(String.valueOf(i));
        }

    }
}