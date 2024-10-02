import org.junit.Test;

import static org.junit.Assert.assertTrue;

//import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void test0() {
        Stack st = new Stack();
        st.push(1);

        int s = st.size();
        assertTrue(s == 1);

        st.push(2);
        s = st.size();
        st.push(3);
        s = st.size();
        assertTrue(s == 3);

       Integer y = (Integer)st.peek();
        assertTrue(y == 3);

        st.pop();
        s = st.size();
        assertTrue(s == 2);
        y = (Integer)st.peek();
        assertTrue(y == 2);

        y= (Integer) st.pop();
        assertTrue( y == 2);
        s = st.size();
        assertTrue(s == 1);
        y = (Integer)st.peek();
        assertTrue( y == 1);


        y = (Integer)st.pop();
        assertTrue(y == 1);
        s = st.size();
        assertTrue(s == 0);
        y = (Integer)st.peek();

        y =  (Integer) st.pop();
        assertTrue(y == null);
        y = (Integer)st.peek();

        y =  (Integer) st.pop();
        assertTrue(y == null);
        s = st.size();
        assertTrue(s == 0);

    }
}
