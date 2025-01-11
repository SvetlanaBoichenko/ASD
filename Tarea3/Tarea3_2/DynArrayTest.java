import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DynArrayTest {
    @Test
    public void test0() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        DynArray d2 = new DynArray<Integer>(Integer.class);
        d2.insert(4,0);

        for (int i = 0; i < 16; i++) {
            d2.append (i);
        }

        assertTrue(d2.balance > 0 );

        d2.remove(0);
        assertTrue(d2.balance > 0 );
        assertTrue(d2.count == 16);

        d2.insert(7,0);
        assertTrue(d2.balance > 0 );

        assertTrue(d2.count == 17);
        d2.remove(d2.count-1);
        assertTrue(d2.balance > 0 );

        assertTrue(d2.count == 16);
        d2.insert(55,d2.count);
        assertTrue(d2.balance > 0 );

        assertTrue(d2.count == 17);
        d2.remove(d2.count-2);
        assertTrue(d2.balance > 0 );

      //  assertTrue(d2.count == 16);

        Integer k = 100;
        d2.insert(k , 15);
        assertTrue(d2.balance > 0 );

        assertTrue(d2.count == 17);
        assertTrue(d2.balance > 0 );

        Integer res = (Integer) d2.getItem(15);
        assertTrue(res == 100);
        assertTrue(d2.balance > 0 );

        res = (Integer) d2.getItem(25);
        assertTrue(res == null);


        d2.remove(15);
        assertTrue(d2.count == 16);

        for (int i = 0; i < 30; i++) {
            d2.insert(i+1, i);
        }

        for (int i = 0; i < 30; i++) {
            d2.insert(i+1, i);
        }
        assertTrue(d2.balance > 0 );

        for (int i = 0; i < 30; i++) {
            d2.remove(i);
        }
        assertTrue(d2.balance > 0 );
        d2.remove(0);
        assertTrue(d2.balance > 0 );

        d2.insert(k , 2);
        d2.insert(k , 15);
        assertTrue(d2.balance > 0 );

    }
}