import  org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NativeDictionary2nTest {
    @Test
    public void test_1() {
        NativeDictionary2n <String> Dict1 = new NativeDictionary2n<> (String.class);
        int res = Dict1.hashFun("a");
        assertEquals (res, 1);


        res = Dict1.hashFun("b");
        assertEquals (res, 2);
        res = Dict1.hashFun("c");
        assertEquals (res, 3);
        res = Dict1.hashFun("d");
        assertEquals (res, 4);


        res = Dict1.hashFun("");
        assertEquals (res, 0);

          res = Dict1.hashFun("3");
        assertEquals (res, 19);

        String  ret = Dict1.get("bbvbvb");
        assertTrue(ret == null);

        Dict1.put("a", "Juan");//
        Dict1.put("b", "Julia");
        Dict1.put("c", "Kate");
        Dict1.put("d", "Alex");
        Dict1.put("V", "Alt");

        int find = Dict1.rindex("j");
        assertTrue(find == 10);
        find = Dict1.rindex("V");
        assertTrue(find == 22);

        assertEquals (Dict1.isKey("a"), true);
        assertEquals (Dict1.isKey("b"), true);
        assertEquals (Dict1.isKey("c"), true);
        assertEquals (Dict1.isKey("d"), true);
        assertEquals (Dict1.isKey("e"), false);

        assertTrue(Dict1.isKey("amigo") == false);


        ret = Dict1.get("a");
        assertTrue(ret == "Juan");
        ret = Dict1.get("b");
        assertTrue(ret == "Julia");
        ret = Dict1.get("bbvbvb");
        assertTrue(ret == null);

        ret = Dict1.get("g");
        assertTrue(ret == null);


    }
}

