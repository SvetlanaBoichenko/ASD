import org.junit.Test;

import static org.junit.Assert.assertTrue;

//import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void test0() {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);

        int s = st.size();
        assertTrue(s == 1);

        st.push(2);
        s = st.size();
        st.push(3);
        s = st.size();
        assertTrue(s == 3);

       Integer y = st.peek();
        assertTrue(y == 3);

     //  Node a = (Node) st.pop();
        y =  st.pop();
        assertTrue(y == 3);
        s = st.size();
        assertTrue(s == 2);
        y = st.peek();
        assertTrue(y == 2);

        y =  st.pop();
        assertTrue( y == 2);
        s = st.size();
        assertTrue(s == 1);
        y = st.peek();
        assertTrue( y == 1);


        y =  st.pop();
        assertTrue(y == 1);
        s = st.size();
        assertTrue(s == 0);
        y = st.peek();
        assertTrue(y == null);

        y =  st.pop();
        assertTrue(y == null);
        y = st.peek();
        assertTrue(y == null);

        s = st.size();
        assertTrue(s == 0);

        st.push(3);
       y= st.pop();


        Stack<String> st1 = new Stack<String>();
        st1.push("1");

        assertTrue(y == null);
        st1.push("2");
        st1.push("3");
        st1.push("4");

        String h1 =  st1.pop();
        h1 =  st1.pop();
        h1 =  st1.pop();


    }
}
