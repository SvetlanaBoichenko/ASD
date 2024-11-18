// Array with counters (to have posible to delete)
public class BloomFilter3
{
    public int filter_len;

    int [] counters;//
    public BloomFilter3(int f_len)
    {
        counters = new int[f_len];
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
        for (int i=0; i<this.filter_len; i++)
        {
            this.counters[i] += mask % 2;
            mask = mask >> 1;
        }
    }

    public void remove(String str1)
    {   // add str1 to filter
        if (isValue(str1))
        {
            int mask = getmask (str1);
            for (int i=0; i<this.filter_len; i++)
            {
                this.counters[i] -= mask % 2;
                mask = mask >> 1;
            }
        }
    }

    public boolean isValue(String str1)
    {
        int mask = getmask (str1);
        for (int i=0; i<this.filter_len; i++)
        {
            if ((mask % 2 == 1) & (this.counters[i] == 0))
            {
                return false;
            }
            mask = mask >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("++!");
    }

}