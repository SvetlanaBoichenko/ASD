import org.junit.Test;
import static org.junit.Assert.*;
public class HashTableTest {
    @Test
    public void testdd() {
        HashTable ht = new HashTable(9, 1);

        ht.dd();
        for (int i = 0; i < ht.size; i++) {
            int index = ht.find(String.valueOf(i));
            assertTrue ( index == -1);
        }
       int aa = 0;
    }

    @Test
    public void testHashS() {
        HashTable ht1 = new HashTable(9, 1);

        for (int i = 0; i < ht1.size; i++) {
            int index = ht1.putS(String.valueOf(i));
        }
        for (int i = 0; i < ht1.size; i++) {
            int index = ht1.findS(String.valueOf(i));
            assertTrue ( index == -1);
        }
    }

}