import java.util.*;

public class BloomFilter2
{
    public int filter_len;

    int bitnum;//
    public BloomFilter2(int f_len)
    {
        bitnum = 0x0;
        filter_len = f_len;
    }

    public int hash1(String str1)
    {// 17
        int res = 0;
        for (int i = 0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            res = (17 * res + code) % this.filter_len;
        }
        return res;
    }

    public int hash2(String str1)
    {  // 223
        int res = 0;
        for (int i = 0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            res = (223 * res + code) % this.filter_len;
        }
        return res;
    }

    public int getmask (String str1){
        int h1 = this.hash1(str1);
        int h2 = this.hash2(str1);
        return (1 << h1 | 1<< h2);

    }

    public void add(String str1)
    {   // add str1 to filter
        int mask = getmask (str1);
        this.bitnum = this.bitnum | mask;
    }

  //  public void remove(String str1)
  //  {   // add str1 to filter
  //      int mask = getmask (str1);
  //      this.bitnum = this.bitnum | mask;
  //  }

    public boolean isValue(String str1)
    {
        int mask = getmask (str1);
        int res = this.bitnum & mask;

        if (res == mask)
            return true;
        return false;
    }

    public BloomFilter2 union(BloomFilter2 other)
    {
        BloomFilter2 result = BloomFilter2(this.filter_len)
        result.bitnum = this.bitnum | other.bitnum;
        return result;
    }

  

}


