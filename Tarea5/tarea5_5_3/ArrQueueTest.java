import org.junit.Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ArrQueueTest {
    @Test
    public void test_enqueue() {
        ArrQueue qe = new ArrQueue(5);
        qe.enqueue(1);
        qe.enqueue(2);
        qe.enqueue(3);
        qe.enqueue(4);
        qe.enqueue(5);
        qe.enqueue(6);

        assertEquals(qe.arr[1].intValue(), 2);
        assertEquals(qe.arr[4].intValue(), 5);
    }
    @Test
    public void test_dequeue() {
        ArrQueue qe1 = new ArrQueue(5);
        qe1.enqueue(1);
        qe1.enqueue(2);
        qe1.enqueue(3);
        qe1.enqueue(4);
        qe1.enqueue(5);

        qe1.dequeue();
        qe1.dequeue();

        assertEquals(qe1.arr[0], null);
        assertEquals(qe1.arr[1], null);
        assertEquals(qe1.arr[2].intValue(), 3);

        qe1.enqueue(7);
        qe1.enqueue(8);
        assertEquals(qe1.arr[0].intValue(), 7);
        assertEquals(qe1.arr[1].intValue(), 8);

        qe1.enqueue(9);
        qe1.dequeue();
        assertEquals(qe1.arr[2], null);
        qe1.enqueue(9);
        assertEquals(qe1.arr[2].intValue(), 9);

    }


}