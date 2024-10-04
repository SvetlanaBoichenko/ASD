import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void test_push_peek() {
        Stack<Integer> st = new Stack<>();
        int s = 0;
        int N = 10;

        Integer pik = 0;
        for (int i = 0; i < N; i++) {
            st.push(i);
            s = st.size();
            assertEquals(s, i + 1);
            pik = st.peek();
            assertEquals(pik.intValue(), i);
        }
    }
    @Test
    public void test_pop() {
        Stack<Integer> st1 = new Stack<>();
        int s1 = 0;
        int N1 = 10;
        Integer p1, pik1;


        s1= st1.size();
        assertEquals(0, s1);

        st1.push(2);
        st1.push(3);
        st1.push(4);
        st1.push(5);
        st1.push(6);

        for (int i = 6; i >= 4; i --) {
            p1 = st1.pop();
            assertEquals(p1.intValue(), i);
            pik1 = st1.peek();
            assertEquals(pik1.intValue(), i - 1);
        }
        s1= st1.size();
        assertEquals(2, s1);
        pik1 = st1.peek();
        assertEquals(pik1.intValue(), 3);

        st1.push (7);
        p1 = st1.pop();
        assertEquals(7, p1.intValue());

        s1= st1.size();
        assertEquals(2, s1);
        pik1 = st1.peek();
        assertEquals(pik1.intValue(), 3);

        p1 = st1.pop();
        assertEquals(3, p1.intValue());

        s1= st1.size();
        assertEquals(1, s1);
        pik1 = st1.peek();
        assertEquals(pik1.intValue(), 2);

        p1 = st1.pop();
        assertEquals(2, p1.intValue());
        s1= st1.size();
        assertEquals(0, s1);
        pik1 = st1.peek();
        assertNull(pik1);

        p1 = st1.pop();
        assertNull(p1);

    }
}
