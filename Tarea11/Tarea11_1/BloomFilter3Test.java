import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BloomFilter3Test {

    @Test
    public void test_Add_remove1() {
        BloomFilter3 bf = new BloomFilter3(32 );
        String str1 = "0123456789";
        int h1 = bf.hash1(str1);
        assertTrue (h1 == 13);
        int h2 = bf.hash2(str1);
        assertTrue (h2 == 5);

        int mask = bf.getmask("0123456789");
        assertTrue (mask == 0b10000000100000);
        bf.add("0123456789");
        bf.add("0123456789");

        assertTrue(bf.isValue("ab") == false);
        assertTrue(bf.isValue("abc") == false);
        assertTrue(bf.isValue("0123456798") == false);
        assertTrue(bf.isValue("0123456789") == true);

        bf.remove("0123456789");
        assertTrue(bf.isValue("0123456789") == true);
        bf.remove("0123456789");
        assertTrue(bf.isValue("0123456789") == false);
    }
    @Test
    public void test_Add_remove2() {
        BloomFilter3 bf2 = new BloomFilter3(4);
        int mask0=  bf2.getmask("0");
        assertTrue (mask0  == 1);
        int mask1=  bf2.getmask("1");
        assertTrue (mask1  == 2);
        int mask2 = bf2.getmask("2");
        assertTrue (mask2  == 4);
        int mask3 = bf2.getmask("3");
        assertTrue (mask3  == 8);

        bf2.add("0");
        bf2.add("1");
        bf2.add("2");
        bf2.add("3");

        bf2.add("2");
        assertTrue(bf2.counters[2] ==2);
        bf2.add("2");
        assertTrue(bf2.counters[2] ==3);
        bf2.remove("2");
        assertTrue(bf2.counters[2] == 2);

        bf2.remove("1");
        assertTrue(bf2.counters[1] == 0);

        assertTrue(bf2.isValue("1") == false);
        assertTrue(bf2.isValue("5") == false);

        int mask6 = bf2.getmask("6");
        assertTrue(bf2.isValue("6") == true);//ложное срабатывание

    }

}