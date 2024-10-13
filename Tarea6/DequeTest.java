import org.junit.Test;
import static org.junit.Assert.*;


public class DequeTest {
    @Test
    public void test_queue() {
        Deque<Integer> dqe = new Deque<Integer>();
        dqe.addTail(1);
        dqe.addTail(2);
        dqe.addTail(3);
        dqe.addTail(4);

        assertTrue(dqe.size() == 4);

        Integer dq =(Integer) dqe.removeFront();
        assertTrue(dq == 1);
        assertTrue(dqe.size() == 3);

        dq =(Integer) dqe.removeTail();
        assertTrue(dq == 4);
        assertTrue(dqe.size() == 2);

        dqe.addFront(33);
        dqe.addFront(44);
        dq = dqe.removeFront();
        assertTrue(dq == 44);
        assertTrue(dqe.size() == 3);

        dq = dqe.removeFront();
        assertTrue(dq == 33);
        assertTrue(dqe.size() == 2);

        dq = dqe.removeFront();
        assertTrue(dq == 2);
        assertTrue(dqe.size() == 1);

        dq = dqe.removeFront();
        assertTrue(dq == 3);
        assertTrue(dqe.size() == 0);

        dq = dqe.removeFront();
        assertTrue(dq == null);
        assertTrue(dqe.size() == 0);
    }
}