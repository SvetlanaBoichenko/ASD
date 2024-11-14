import  org.junit.Test;

public class NativeCacheTest {
    @Test
    public void test_put() {
        NativeCache nc = new  NativeCache     (5, Integer.class);
        nc.put("s1",11);
        nc.put("s2",12);
        nc.put("s3",13);
        nc.put("s4",14);
        nc.put("s5",15);
        nc.put("s6",16);

        int res = (int) nc.get("s3");

    }

}