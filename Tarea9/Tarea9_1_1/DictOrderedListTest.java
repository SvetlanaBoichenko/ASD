import  org.junit.Test;

import static org.junit.Assert.assertTrue;

public class  DictOrderedListTest {
    @Test
    public void test_put() {
        DictOrderedList <Integer> nd2 = new  DictOrderedList <>(true);
        Integer val = 2;
        nd2.put ("A", 2);
        nd2.put ("B", 5);
        nd2.put ("C", 8);
        nd2.put ("C", 1);
    }
    @Test
    public void test_get() {

    }

}
