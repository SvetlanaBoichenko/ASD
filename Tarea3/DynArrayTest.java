import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DynArrayTest {
    @Test
    public void test0() {
        DynArray d1 = new DynArray(Integer.class);
        d1.makeArray(100);
        assertTrue(d1.capacity == 128);

        d1.makeArray(50);
        assertTrue(d1.capacity == 56);

        DynArray d2 = new DynArray<Integer>(Integer.class);
        assertTrue(d2.capacity == 16);
        d2.makeArray(500);
        d2.makeArray(0);
        assertTrue(d2.capacity == 16);
        d2.makeArray(0);

        d2.makeArray(17);
        assertTrue(d2.capacity == 32);
        d2.makeArray(25);
        assertTrue(d2.capacity == 32);
        d2.makeArray(200);
        assertTrue(d2.capacity == 256);
        d2.makeArray(5);
        assertTrue(d2.capacity == 16);

        int a = 1;
        for (int i = 0; i < 16; i++) {
            d2.append(i);
        }

        assertTrue(d2.capacity == 16);
        assertTrue(d2.count == 16);

        d2.insert(100, 15);
        assertTrue(d2.capacity == 32);
        assertTrue(d2.count == 17);

        Integer res = (Integer) d2.getItem(15);
        assertTrue(res == 100);

        res = (Integer) d2.getItem(25);
        assertTrue(res == null);

        d2.remove(15);
        assertTrue(d2.capacity == 32);
        assertTrue(d2.count == 16);


        for (int i = 10; i < 30; i++) {
            d2.insert(i, i);
        }

        assertTrue(d2.capacity == 64);
        assertTrue(d2.count == 36);


        for (int i = 0; i < 4; i++) {
            d2.remove(i);
        }

            assertTrue(d2.count == 32);
            assertTrue(d2.capacity == 64);
        d2.remove(0);

        assertTrue(d2.count == 31);
        assertTrue(d2.capacity == 42);
        d2.remove(0);
        assertTrue(d2.count == 30);
        assertTrue(d2.capacity == 42);

    }
}