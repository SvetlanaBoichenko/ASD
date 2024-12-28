import  org.junit.Test;


public class NativeDictionary2Test {
    @Test
    public void test_put() {
        NativeDictionary2 <Integer> nd2 = new NativeDictionary2 <>(5, Integer.class);
        int val = 0;
        nd2.put ("A", val);
        val = val+1;
        nd2.put ("B", val);
        val = val+1;
        nd2.put ("B", val);
        val =  val+1;
        nd2.put ("C", val);
        val =  100;
        nd2.put ("A", val);
        val =  100;
        nd2.put ("B", val);

    }
    @Test
    public void test_get() {

    }

}