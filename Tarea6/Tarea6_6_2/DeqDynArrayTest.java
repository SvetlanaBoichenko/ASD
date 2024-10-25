import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


public class DeqDynArrayTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        DeqDynArray d2 = new DeqDynArray<Integer>(Integer.class);

        for (int i = 0; i < 17; i++) {
            d2.append(i);
        }
        assertTrue(d2.capacity == 32);
        assertTrue(d2.count == 17);

        d2.appendF(12);

    assertTrue(d2.capacity == 32);
    assertTrue(d2.count == 18);

      int n = d2.count;
      for (int i = d2.findex; i < n; i++) {
          d2.appendF(i);
      }

        assertTrue(d2.capacity == 64);
        assertTrue(d2.count == 32);

        d2.remove();
        assertTrue(d2.count == 31);

        d2.removeF();
        assertTrue(d2.count == 30);


    }
}

