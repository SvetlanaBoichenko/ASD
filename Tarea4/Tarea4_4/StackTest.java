import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void test_sbalans() {
        Stack<Character> st = new Stack<>();
        String tsts = "()()()";
        assertTrue(st.sbalans(tsts) ==true );

        Stack<Character> st1 = new Stack<>();
        String tsts2 = "((())";
        assertTrue(st1.sbalans(tsts2) ==false );

        Stack<Character> st2 = new Stack<>();
        String tsts3 = "())(";
        assertTrue(st2.sbalans(tsts2) ==false );

        Stack<Character> st3 = new Stack<>();
        String tsts4 = "))((";
        assertTrue(st3.sbalans(tsts4) ==false );

        Stack<Character> st4 = new Stack<>();
        String tsts5 = ")()()()";
        assertTrue(st4.sbalans(tsts5) ==false );

        Stack<Character> st5 = new Stack<>();
        String tsts6 = "(((())))())";
        assertTrue(st5.sbalans(tsts6) == false );

        Stack<Character> st6 = new Stack<>();
        String tsts7 = "(() ( ()() ) ())";
        assertTrue(st6.sbalans(tsts7) ==true );
    }
    @Test
    public void test_sbalansd() {
        Stack<Character> st2 = new Stack<>();
        String tsts2 = "()([])()";
        assertTrue(st2.sbalansd(tsts2) ==true );

        Stack<Character> st3 = new Stack<>();
        String tsts3 = "({(}))";
        assertTrue(st3.sbalansd(tsts3) ==false );

        Stack<Character> st4 = new Stack<>();
        String tsts4 = "{())(}";
        assertTrue(st4.sbalansd(tsts4) ==false );

        Stack<Character> st5 = new Stack<>();
        String tsts5 = "))((";
        assertTrue(st5.sbalansd(tsts5) ==false );

        Stack<Character> st6 = new Stack<>();
        String tsts6 = ")()()()";
        assertTrue(st6.sbalansd(tsts6) ==false );

        Stack<Character> st7 = new Stack<>();
        String tsts7 = "((()()()()))))";
        assertTrue(st2.sbalansd(tsts7) == false );

        Stack<Character> st8 = new Stack<>();
        String tsts8 = "((){}(())()[])";
        assertTrue(st8.sbalansd(tsts8) == true );

        Stack<Character> st9 = new Stack<>();
        String tsts9 = "{}((){}([()])()[])";
        assertTrue(st8.sbalansd(tsts9) == true );
    }

    @Test
    public void test_min() {
        stackcomm  sst = new stackcomm();
        sst.pushm(10);
        assertTrue(sst.minofstack()== 10);
        sst.pushm(1);
        assertTrue(sst.minofstack()== 1);
        sst.pushm(2);
        assertTrue(sst.minofstack()== 1);

    }

    @Test
    public void test_av() {
        stackcomm sst = new stackcomm();
        sst.pushav(10);
        assertTrue(sst.averofstack() == 10);
        sst.pushav(1);
        assertTrue(sst.averofstack()== 5.5);
        sst.pushav(4);
        assertTrue(sst.averofstack() == 5);
        sst.pushav(-3);
        assertTrue(sst.averofstack() == 3);
        sst.popav();
        assertTrue(sst.averofstack() == 5);
    }

    @Test
  public void test_Postfix (){
        stackpostfix stpostfix = new stackpostfix();
        Stack <String> std = new Stack();
        std.push("=");
        std.push("+");
        std.push ("9");
        std.push ("*");
        std.push ("5");
        std.push ("+");
        std.push ("2");
        std.push ("8");
       // 8 2 + 5 * 9 + =
        Integer res =  stpostfix.result (std);
        assertTrue(res == 59);
    //    1 2 + 3 *
        Stack <String> std2 = new Stack();
        std2.push("=");
        std2.push("*");
        std2.push ("3");
        std2.push ("+");
        std2.push ("2");
        std2.push ("1");

        // 8 2 + 5 * 9 + =
        Integer res2 =  stpostfix.result (std2);
        assertTrue(res2 == 9);
    }

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