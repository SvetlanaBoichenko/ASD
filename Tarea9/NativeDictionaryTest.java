import  org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NativeDictionaryTest {
    @Test
    public void test_1() {
         NativeDictionary <String> Dict1 = new NativeDictionary<> (17, String.class);
         int res = Dict1.hashFun("amigo");
         assertEquals (res, 15);

         res = Dict1.hashFun("a");
         assertEquals (res, 12);

         res = Dict1.hashFun("");
         assertEquals (res, 0);

         res = Dict1.hashFun("3");
         assertEquals (res, 0);

         Dict1.put("amigo", "Juan");
         Dict1.put("a", "Benicasim");

         assertTrue(Dict1.isKey("amigo") == true);
         assertTrue(Dict1.isKey("amigos") == false);

         String ret = Dict1.get("a");
         assertTrue(ret == "Benicasim");
         ret = Dict1.get("b");
         assertTrue(ret == null);

    }
}