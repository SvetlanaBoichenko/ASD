import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class QueueTest {
    @Test
    public void test_queue() {
        Queue<Integer> qe = new Queue<Integer>();
        qe.enqueue(1);
        qe.enqueue(2);
        qe.enqueue(3);
        qe.enqueue(4);
        assertTrue(qe.size() == 4);

       Integer dq = qe.dequeue();
        assertTrue(dq == 1);
        dq = qe.dequeue();
        assertTrue(dq == 2);
        assertTrue(qe.size() == 2);
        dq = qe.dequeue();
        assertTrue(dq == 3);
        dq = qe.dequeue();
        assertTrue(dq == 4);
        assertTrue(qe.size() == 0);
    }
}