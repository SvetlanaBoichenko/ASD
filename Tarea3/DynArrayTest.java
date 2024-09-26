import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DynArrayTest {
    @Test
    public void test0() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        DynArray d2 = new DynArray<Integer>(Integer.class);

     //   Во время выполнения вы можете создать экземпляр Integer,
     //   экземпляр использует объектно-подобную компоновку памяти, например, с указателем
     //   в начале, указывающим на Integer.class,
     //   что обеспечивает полиморфное поведение java во время выполнения.

        for (int i = 0; i < 16; i++) {
            d2.append (i);
        }

        assertTrue(d2.capacity == 16);
        assertTrue(d2.count == 16);

        Integer k = 100;          //array = (T[]) Array.newInstance(this.clazz, new_capacity);
        d2.insert(k , 15);
        assertTrue(d2.capacity == 32);
        assertTrue(d2.count == 17);

       // d2.insert(k , -2);
        // d2.insert(k , 150);
        //assertTrue(d2.capacity == 32);
        //assertTrue(d2.count == 17);

        Integer res = (Integer) d2.getItem(15);
        assertTrue(res == 100);

        res = (Integer) d2.getItem(25);
        assertTrue(res == null);

        d2.remove(15);
        assertTrue(d2.capacity == 32);
        assertTrue(d2.count == 16);


        for (int i = 10; i < 30; i++) {

            d2.insert(i+1, i);
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