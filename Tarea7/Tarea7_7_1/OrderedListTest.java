
import com.sun.source.tree.AssertTree;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class OrderedListTest {
    @Test
    public void test_order() {
        OrderedList<Integer> list1 = new OrderedList<>(true);
        OrderedList<Integer> list2 = new OrderedList<>(true);
        OrderedList<Integer> list3 = new OrderedList<>(true);

        list1.add(1);
        list1.add(2);
        list1.add(8);
        list1.add(10);
        list1.add(11);
        list1.add(12);

        list2.add(4);
        list2.add(5);
        list2.add(11);
        list2.add(15);
        list2.add(15);

        OrderedList<Integer> list4 = list3.Orderlists(list1, list2);

        assertEquals(list4.head.value.intValue(), 1);
        assertEquals(list4.head.next.value.intValue(), 2);
        assertEquals(list4.head.next.next.value.intValue(), 4);
        assertEquals(list4.head.next.next.next.value.intValue(), 5);
        assertEquals(list4.tail.value.intValue(), 15);
        assertEquals(list4.tail.prev.value.intValue(), 15);
        assertTrue(list4.count() == 11);

        list1.clear(true);
        list2.clear(true);
        // list4.clear(true);

        list1.add(4);
        list1.add(5);
        list1.add(11);
        list1.add(15);
        list1.add(15);

        list2.add(1);
        list2.add(2);
        list2.add(8);
        list2.add(10);
        list2.add(11);
        list2.add(12);
        OrderedList<Integer> list5 = list3.Orderlists(list1, list2);

        assertEquals(list5.head.value.intValue(), 1);
        assertEquals(list5.head.next.value.intValue(), 2);
        assertEquals(list5.head.next.next.value.intValue(), 4);
        assertEquals(list5.head.next.next.next.value.intValue(), 5);
        assertEquals(list5.tail.value.intValue(), 15);
        assertEquals(list5.tail.prev.value.intValue(), 15);
        assertTrue(list5.count() == 11);
    }

    @Test
    public void test_Lookforsblist (){
        OrderedList<Integer> list1 = new OrderedList(true);

        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(11);
        list1.add(15);
        list1.add(15);

        OrderedList<Integer> list2 = new OrderedList(true);
        list2.add(4);
        list2.add(5);
        list2.add(11);

        boolean b = list1.LookForSublist (list2);
        assertTrue(b == true);

        list2.delete(11);
        list2.add(15);

         b = list1.LookForSublist (list2);
        assertTrue(b == false);

    }

    @Test
    public void test_Dublicate () {
        OrderedList<Integer> list1 = new OrderedList(true);
        list1.add(1);
        list1.add(1);
        list1.add(4);
        list1.add(4);
        list1.add(5);
        list1.add(5);
        list1.add(11);
        list1.add(15);
        list1.add(15);

        list1.DelDublicate();
        assertEquals(list1.tail.value.intValue(), 15);
        assertEquals(list1.tail.prev.value.intValue(), 11);
        assertTrue(list1.count() == 5);
    }

    @Test
    public void test_SumDublicate () {
        OrderedList<Integer> list1 = new OrderedList(true);
        list1.add(1);
        list1.add(1);
        list1.add(4);
        list1.add(4);
        list1.add(5);
        list1.add(5);

        list1.add(11);
        list1.add(15);
        list1.add(15);
        list1.add(15);

        int res = 15;
        assertTrue (list1.SumDublicate() == res);
    }
}

