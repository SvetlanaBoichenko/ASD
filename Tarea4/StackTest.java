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

        Node y = (Node)st.peek();
        assertTrue((Integer)y.value == 3);

        st.pop();
        s = st.size();
        assertTrue(s == 2);


        y= (Node) st.pop();
        assertTrue( (Integer)y.value == 2);
        Node r1 =  (Node) st.pop();
        assertTrue((Integer)r1.value == 1);
        r1 =  (Node) st.pop();
        assertTrue(r1 == null);

        y =  (Node) st.pop();
        assertTrue(y == null);




        s = st.size();
        assertTrue(s == 0);

    }
}
