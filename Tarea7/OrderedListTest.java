import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class OrderedListTest {
    @Test
    public void test_compare() {
        OrderedList odl = new OrderedList(true);

        Integer a2 = 8;
        Integer a1 = 8;
        int res = odl.compare(a1,a2);
        assertTrue(res == 0);

        a1 = 9;
        res = odl.compare(a1,a2);
        assertTrue(res == 1);

        a1 = 2;
        res = odl.compare(a1,a2);
        assertTrue(res == -1);
    }

    @Test
    public void test_Add() {
        OrderedList<Integer> odl1 = new OrderedList<Integer>(true);
        odl1.add(1);
        odl1.add(2);
        odl1.add(3);
        odl1.add(4);
        odl1.add(5);

        assertTrue(odl1.count()== 5);
        assertTrue(odl1.head.value == 1);
        assertTrue(odl1.head.next.value == 2);
        assertTrue(odl1.head.next.next.value == 3);
        assertTrue(odl1.tail.value == 5);
        assertTrue(odl1.tail.prev.value == 4);

        odl1.add(1);
        assertTrue(odl1.count()== 6);
        assertTrue(odl1.head.value == 1);
        assertTrue(odl1.head.next.value == 1);
        assertTrue(odl1.head.next.next.value == 2);

        odl1.add(2);
        assertTrue(odl1.count()== 7);
        assertTrue(odl1.head.next.next.next.value == 2);

        odl1.add(3);
        odl1.add(4);
        odl1.add(5);
        assertTrue(odl1.tail.value == 5);
        assertTrue(odl1.tail.prev.value == 5);
        assertTrue(odl1.count()== 10);

        odl1.add(2);
        assertTrue(odl1.count()== 11);
        assertTrue(odl1.head.next.next.next.value == 2);
        assertTrue(odl1.head.next.next.next.next.value == 2);
    }

    @Test
    public void test_find() {
        OrderedList<Integer> odl2 = new OrderedList<Integer>(true);
        odl2.add(1);
        odl2.add(2);
        odl2.add(2);
        odl2.add(3);
        odl2.add(3);
        odl2.add(4);
        odl2.add(5);

        Node nod =  odl2.find(5);
        assertEquals(nod.value, 5);
        nod = odl2.find(2);
        assertEquals(nod.value, 2);
        nod =  odl2.find(3);
        assertEquals(nod.value, 3);
        nod =  odl2.find(1);
        assertEquals(nod.value, 1);
        nod =  odl2.find(11);
        assertEquals(nod, null);
    }

    @Test
    public void test_delete() {
        OrderedList<Integer> odl3 = new OrderedList<Integer>(true);
        odl3.add(1);
        odl3.add(3);
        odl3.add(2);
        odl3.add(0);
        odl3.add(13);
        odl3.add(14);
        odl3.add(5);

        odl3.delete(13);
        Node nod =  odl3.find(13);
        assertEquals(nod, null);

        odl3.delete(0);
        nod =  odl3.find(0);
        assertEquals(nod, null);

        odl3.delete(2);
        nod =  odl3.find(2);
        assertEquals(nod, null);

        odl3.delete(14);
        nod =  odl3.find(14);
        assertEquals(nod, null);

        odl3.clear(true);
        assertEquals(odl3.count(), 0 );
    }
}