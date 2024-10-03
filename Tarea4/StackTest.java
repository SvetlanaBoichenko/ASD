import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void test0() {
        Stack<Integer> st = new  Stack<>();
        int s = 0;
        int N = 10;

        Integer pik = 0;
        for (int i = 0; i < N; i ++) {
            st.push(i);
            s = st.size();
            assertEquals(s, i + 1);
            pik = st.peek();
            assertEquals(pik.intValue(), i);
        }

        Integer p = 0;
        for (int i = N-1; i >= 0; i --) {
            p = st.pop();
            assertEquals(p.intValue(), i);
            s = st.size();
            assertEquals(s, i);

            if (i > 0) {
                pik = st.peek();
                assertEquals(pik.intValue(), i - 1);
            }
            else {
                pik = st.peek();
                assertNull(pik);
            }
        }

         s = st.size();
        assertEquals(0, s);

        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);

        for (int i = 6; i >= 4; i --) {
            p = st.pop();
            assertEquals(p.intValue(), i);
        }

        st.push (7);
        p = st.pop();
        assertEquals(7, (int) p);
        p = st.pop();
        assertEquals(3, (int) p);
        p = st.pop();
        assertEquals(2, (int) p);
        p = st.pop();
        assertNull(p);

    }
}
