import  org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NativeDictionary2Test {
    @Test
    public void test_put() {
        NativeDictionary2 <Integer> nd2 = new NativeDictionary2 <>(19, Integer.class);
       Integer val = 2;
        nd2.put ("Ana", val);
        val = val+3;
        nd2.put ("Ana1", val);
        val = val+3;
        nd2.put ("Ana2", val);
        val = 1;
        nd2.put ("Ana2", val);
    }
    @Test
    public void test_get() {

    }

}
