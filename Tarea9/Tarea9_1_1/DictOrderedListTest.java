import  org.junit.Test;
import static org.junit.Assert.assertTrue;

public class  DictOrderedListTest {
    @Test
    public void test_put() {
        DictOrderedList<Integer> nd2 = new DictOrderedList<>(true);

        nd2.put("A", 2);
        nd2.put("D", 5);
        nd2.put("C", 8);
        nd2.put("B", 1);

        assertTrue(nd2.head.par.key == "A");
        assertTrue(nd2.head.next.par.key == "B");
        assertTrue(nd2.tail.par.key == "D");
        assertTrue(nd2.tail.prev.par.key == "C");

        DictOrderedList<Integer> nd3 = new DictOrderedList<>(false);
        nd3.put("mama", 2);
        nd3.put("papa", 5);
        nd3.put("pap", 5);
        nd3.put("ded", 8);
        nd3.put("baba", 1);
        assertTrue(nd3.head.par.key.equals("papa") == true);
        assertTrue(nd3.head.next.par.key.equals("pap") == true);
        assertTrue(nd3.tail.par.key.equals("baba") == true);
        assertTrue(nd3.tail.prev.par.key.equals("ded") == true);
    }

    @Test
    public void test_get() {
        DictOrderedList<Integer> nd3 = new DictOrderedList<>(false);
        nd3.put("mama", 2);
        nd3.put("papa", 5);
        nd3.put("pap", 5);
        nd3.put("ded", 8);
        nd3.put("baba", 1);

        int res = nd3.get("mama");
        assertTrue(res == 2);
        res = nd3.get("ded");
        assertTrue(res == 8);
    }

    @Test
    public void test_isKey() {
        DictOrderedList<Integer> nd3 = new DictOrderedList<>(false);
        nd3.put("ded", 8);
        nd3.put("mama", 2);
        nd3.put("papa", 5);
        nd3.put("pap", 5);
        nd3.put("baba", 1);

        assertTrue(nd3.isKey("ded") == true);
        assertTrue(nd3.isKey("bambino") == false);

        int ind = nd3. getkeyindex("ded");
        assertTrue(ind == 3);
        ind = nd3. getkeyindex("bebe");
        assertTrue(ind == -1);


    }
}