import  org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BloomFilterTest {
    @Test
    public void test_hash1() {
        BloomFilter bf = new BloomFilter(32 );
        int res1 = bf.hash1("ab");
        assertTrue (res1 == 19);
        int res2 = bf.hash1("ba");
        assertTrue (res2 == 3);
    }
    @Test
    public void test_hash2() {
    }
    @Test
    public void test_Add1() {
        BloomFilter bf = new BloomFilter(32 );
        String str1 = "0123456789";
        int h1 = bf.hash1(str1);
        assertTrue (h1 == 13);
        int h2 = bf.hash2(str1);
        assertTrue (h2 == 5);

        int mask = bf.getmask("0123456789");
        assertTrue (mask == 0b10000000100000);
        bf.add("0123456789");
        mask = bf.getmask("1234567890");
        assertTrue (mask == 0b101000000000000000000000000000);
        bf.add("1234567890");
        bf.add("2345678901");
        bf.add("3456789012");
        bf.add("4567890123");
        bf.add("5678901234");
        bf.add("6789012345");
        bf.add("7890123456");
        bf.add("8901234567");
        bf.add("9012345678");

        assertTrue(bf.isValue("0123456789") == true);
        assertTrue(bf.isValue("1234567890") == true);
        assertTrue(bf.isValue("2345678901") == true);
        assertTrue(bf.isValue("3456789012") == true);
        assertTrue(bf.isValue("4567890123") == true);
        assertTrue(bf.isValue("5678901234") == true);
        assertTrue(bf.isValue("6789012345") == true);
        assertTrue(bf.isValue("7890123456") == true);
        assertTrue(bf.isValue("8901234567") == true);
        assertTrue(bf.isValue("9012345678") == true);

      //  assertTrue(bf.isValue("9012354678") == false);
        assertTrue(bf.isValue("ab") == false);
        assertTrue(bf.isValue("abc") == false);
        assertTrue(bf.isValue("0123456798") == false);
    }


}