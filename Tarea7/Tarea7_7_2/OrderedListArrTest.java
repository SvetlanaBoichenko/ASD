
import com.sun.source.tree.AssertTree;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class OrderedListArrTest {
    @Test
    public void test_order() {
        OrderedListArr<Integer>odl1 = new OrderedListArr<>(Integer.class,true);

        odl1.add(1);
        odl1.add(2);
        odl1.add(3);
        odl1.add(4);
        odl1.add(5);
        odl1.add(3);
        odl1.add(4);
        odl1.add(5);

        assertTrue(odl1.count()== 8);
        assertTrue(odl1.find(1) == 0);
        assertTrue(odl1.find(2) == 1);
        assertTrue(odl1.find(3) == 3);
        assertTrue(odl1.find(4) == 5);
        assertTrue(odl1.find(5) == 6);
        assertTrue(odl1.count()== 8);
        odl1.clear(true);

        odl1.add(1);
        odl1.add(2);
        odl1.add(3);
        odl1.add(4);
        odl1.add(5);

        assertTrue(odl1.find(1) == 0);
        assertTrue(odl1.find(2) == 1);
        assertTrue(odl1.find(3) == 2);
        assertTrue(odl1.find(4) == 3);
        assertTrue(odl1.find(5) == 4);
        assertTrue(odl1.find(15) == -1);


        OrderedListArr<Integer> odl2 = new OrderedListArr<>(Integer.class,false);
        odl2.add(5);
        odl2.add(4);
        odl2.add(3);
        odl2.add(2);
        odl2.add(1);

        assertTrue(odl2.find(5) == 0);
        assertTrue(odl2.find(4) == 1);
        assertTrue(odl2.find(3) == 2);
        assertTrue(odl2.find(2) == 3);
        assertTrue(odl2.find(1) == 4);
        assertTrue(odl2.find(11) == -1);

     odl2.delete(3);
     assertTrue(odl2.count()== 4);
     assertTrue(odl2.find(3) == -1);
        odl2.delete(1);
        assertTrue(odl2.count()== 3);
        assertTrue(odl2.find(1) == -1);
        odl2.delete(5);
        assertTrue(odl2.count()== 2);
        assertTrue(odl2.find(5) == -1);
        odl2.delete(4);
        assertTrue(odl2.count()== 1);
        assertTrue(odl2.find(4) == -1);

        odl2.delete(2);
        assertTrue(odl2.count()== 0);
        assertTrue(odl2.find(2) == -1);


    }

}


