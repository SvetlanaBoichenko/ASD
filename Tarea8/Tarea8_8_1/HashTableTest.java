import  org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class HashTableTest {
    @Test
    public void test_hash() {
        HashTable HTab = new HashTable (17, 1);
        int res = HTab.hashFun("amigo");
        assertEquals (res, 15);

        res = HTab.hashFun("a");
        assertEquals (res, 12);

        res = HTab.hashFun("");
        assertEquals (res, 0);

        res = HTab.hashFun("3");
        assertEquals (res, 0);
    }

    @Test
    public void test_has2h() {
        HashTable HTab = new HashTable (17, 1);
        int res = HTab.hashFun2("amigo");
        assertEquals (res, 7);

        res = HTab.hashFun2("a");
        assertEquals (res, 16);

        res = HTab.hashFun2("");
        assertEquals (res, 0);

        res = HTab.hashFun2("3");
        assertEquals (res, 8);
    }


    @Test
    public void test_put2() {
        HashTable Htab = new HashTable (17, 1);
        int res = Htab.put2("a");
         res = Htab.put2("b");
         res = Htab.put2("");
         res = Htab.put2("3");
    }

    @Test
    public void test_seek() {
        HashTable HTab = new HashTable (17, 3);
        HTab.slots[15] = "amigo";
        assertEquals(HTab.seekSlot("amigo"), 15);
        HTab.slots[12] = "a";
        assertEquals(HTab.seekSlot("a"), 12);

        assertEquals(HTab.seekSlot("0"), 14);

        HTab.slots[14] = "13";
        assertEquals(HTab.seekSlot("0"), 0);

        int r =  HTab.hashFun("Juan");
        assertEquals(HTab.seekSlot("Juan"), r);
    }

    @Test
    public void test_put() {
        HashTable HTab = new HashTable (17, 2);

        HTab.put("hola");
        int ind = HTab.seekSlot("hola");
        assertTrue(ind == 12);

        HTab.put("");
        assertEquals(HTab.slots[0], "");
    }

    @Test
    public void test_find (){
        HashTable HTab = new HashTable (17, 2);
        HTab.put("hola");

        int f = HTab.find("hola");
        assertTrue(f == 12);

        f = HTab.find("ola");
        assertTrue(f == -1);


    }
}