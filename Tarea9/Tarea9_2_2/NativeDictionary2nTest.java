import  org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NativeDictionary2nTest {
    @Test
    public void test_1() {
        NativeDictionary2n <String> Dict1 = new NativeDictionary2n<> (String.class);
        int res = Dict1.hashFun(1);
        assertEquals (res, 1);


        res = Dict1.hashFun(35);
        assertEquals (res, 3);
        res = Dict1.hashFun(10);
        assertEquals (res, 10);
        res = Dict1.hashFun(40);
        assertEquals (res, 8);


        res = Dict1.hashFun(null);
        assertEquals (res, -1);

        res = Dict1.hashFun(51);
        assertEquals (res, 19);

        String  ret = Dict1.get(15);
        assertTrue(ret == null);

        Dict1.put(1, "Juan");//
        Dict1.put(33, "Julia");
        Dict1.put(3, "Kate");
        Dict1.put(35, "Alex");
        Dict1.put(5, "Alt");

        int find = Dict1.rindex(10);
        assertTrue(find == 10);
        find = Dict1.rindex(53);
        assertTrue(find == 21);

        assertEquals (Dict1.isKey(1), true);
        assertEquals (Dict1.isKey(33), true);
        assertEquals (Dict1.isKey(3), true);
        assertEquals (Dict1.isKey(35), true);
        assertEquals (Dict1.isKey(5), true);

        assertTrue(Dict1.isKey(16) == false);


        ret = Dict1.get(1);
        assertTrue(ret == "Juan");
        ret = Dict1.get(33);
        assertTrue(ret == "Julia");
        ret = Dict1.get(19);
        assertTrue(ret == null);

        ret = Dict1.get(20);
        assertTrue(ret == null);


    }
}



