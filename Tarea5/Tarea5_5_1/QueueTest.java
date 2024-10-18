import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void test_dequeue_n() { // volver y eliminar head
        Queue<Integer> qen = new Queue<Integer>();
        qen.enqueue(1);
        qen.enqueue(2);
        qen.enqueue(3);
        qen.enqueue(4);

        Node ret = qen.dequeue_n();
        assertEquals(ret.value, 1);
        assertTrue(qen.size() == 3);

        ret = qen.dequeue_n();
        assertEquals(ret.value, 2);
        assertTrue(qen.size() == 2);

        ret = qen.dequeue_n();
        assertEquals(ret.value, 3);
        assertTrue(qen.size() == 1);

        ret = qen.dequeue_n();
        assertEquals(ret.value, 4);
        assertTrue(qen.size() == 0);
    }

    @Test
    public void test_equeue_n() {
        Queue<Integer> qen2 = new Queue<Integer>();
        Node<Integer> nod1 = new Node<Integer> (1);
        Node<Integer> nod2 = new Node <Integer>(2);
        Node<Integer> nod3 = new Node<Integer> (3);
        Node<Integer> nod4 = new Node<Integer> (4);

        qen2.enqueue_n(nod1);
        assertTrue(qen2.head.value == 1);
        assertTrue(qen2.size() == 1);

        qen2.enqueue_n(nod2);
        assertTrue(qen2.head.value == 1);
        assertTrue(qen2.head.next.value == 2);
        assertTrue(qen2.size() == 2);
    }

    @Test
    public void test_rotate() {          //sdvig na N c
        Queue<Integer> qen = new Queue<Integer>();
        qen.enqueue(1);
        qen.enqueue(2);
        qen.enqueue(3);
        qen.enqueue(4);
        qen.enqueue(5);

        qen.rotate(3);
        assertTrue(qen.tail.value == 3);
        assertTrue(qen.tail.prev.value == 2);
        assertTrue(qen.head.next.value== 5);
        assertTrue(qen.head.value== 4);
        assertTrue(qen.head.next.next.value== 1);
    }

    @Test
    public void test_rotateall(){
        Queue<Integer> qen4 = new Queue<Integer>();
        qen4.enqueue(1);
        qen4.enqueue(2);
        qen4.enqueue(3);
        qen4.enqueue(4);
        qen4.enqueue(5);

        Queue rqen = qen4.rotateall();
        assertEquals(rqen.tail.value, 1);
        assertEquals(rqen.tail.prev.value, 2);
        assertEquals(rqen.head.value, 5);
        assertEquals(rqen.head.next.value, 4);
        assertEquals(rqen.tail.prev.prev.value, 3);






    }
}