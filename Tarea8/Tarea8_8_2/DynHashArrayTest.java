import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynHashArrayTest {
     @Test
     public void testput() {
         DynHashArray harr = new DynHashArray();
         harr.put("a");
         for (int i = 0; i <= 16; i++){
            harr.put(String.valueOf(i));
         }
         assertTrue(harr.capacity == 41);

         String s = harr.getItem(8);
         assertEquals(s, "1");
         harr.put(")");
         assertEquals( harr.getItem(0), ")");
         harr.put("*");
         assertEquals( harr.getItem(1), "*");

         harr.remove("*");
         assertEquals(harr.count, 19);
         assertEquals(harr.find("*"), -1);
         assertEquals(harr.find("7"), 1);


     }
 }