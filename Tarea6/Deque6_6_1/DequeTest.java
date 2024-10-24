import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class DequeTest {
    @Test
    public void test_palindrom() {
        Deque<Character> qs = new  Deque <Character>();

        boolean r = true;
        r =qs.ispalindrom("mamam");
        assertTrue(r == true);

        r =qs.ispalindrom("maam");
        assertTrue(r == true);

        r =qs.ispalindrom("mamnam");
        assertTrue(r == false);
        r =qs.ispalindrom("manmnam");
        assertTrue(r == true);
    }

    @Test
    public void test_min() {
        Dequemin qmin = new  Dequemin();
        Integer min;
        qmin.addFrontm(1);
        qmin.addTailm(2);
        min = qmin.minval();
        assertTrue( min == 1);

        qmin.addFrontm(3);
        qmin.addFrontm(1);
        min = qmin.minval();
        assertTrue( min == 1);

        qmin.addFrontm(-3);
        min = qmin.minval();
        assertTrue( min == -3);

        qmin.addTailm(-5);//
        min = qmin.minval();
        assertTrue( min == -5);

        qmin.addTailm(5);//
        min = qmin.minval();
        assertTrue( min == -5);

        qmin.addFrontm(-2);
        min = qmin.minval();
        assertTrue( min == -5);
    }

    @Test
    public void test_sk() {
        Deque<Character> qs2 = new Deque<Character>();

        String ts = "()([])()";
        assertTrue(qs2.sbalansS(ts) == true);

        Deque<Character> qs3 = new Deque<Character>();
        String ts3 = "({})";
        assertTrue(qs3.sbalansS(ts) == true);

        Deque<Character> qs4 = new Deque<Character>();
        String ts4 = "({(}))";
        assertTrue(qs3.sbalansS(ts4) == false);

        Deque<Character> qs5 = new Deque<Character>();
        String ts5 = "))((";
        assertTrue(qs3.sbalansS(ts5) == false);

        Deque<Character> qs6 = new Deque<Character>();
        String ts6 = "))((";
        assertTrue(qs3.sbalansS(ts6) == false);

        Deque<Character> qs7 = new Deque<Character>();
        String st9 = "{}((){}([()])()[])";
        assertTrue(qs7.sbalansS(st9) == true);
    }
}