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
          res = Dict1.hashFun("b");
          assertEquals (res, 13);
          res = Dict1.hashFun("c");
          assertEquals (res, 14);
          res = Dict1.hashFun("d");
          assertEquals (res, 15);


          res = Dict1.hashFun("");
          assertEquals (res, 0);

          res = Dict1.hashFun("3");
          assertEquals (res, 0);

          String  ret = Dict1.get("bbvbvb");
          assertTrue(ret == null);

          Dict1.put("a", "Juan");//
          Dict1.put("b", "Julia");
          Dict1.put("c", "Kate");
          Dict1.put("d", "Alex");
          Dict1.put("V", "Alt");

         int find = Dict1.rindex("j");
         assertTrue(find == 4);
         find = Dict1.rindex("V");
         assertTrue(find == 1);
          find = Dict1.rindex("g");
         assertTrue(find == 2);



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





