import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DynArrayNTest {
        @Test
        public void makenewkoef () {
            int nd = 4;
            int [] dm = {5,6,7,8};
            int [] newkoef = {336,56,8,1};

            DynArrayN<Integer> dynarr = new DynArrayN<>(Integer.class, nd, dm);
            dynarr.make_newkoef();
            assertArrayEquals (dynarr.koef_arr, newkoef);

            nd = 3;
            int [] dm2 = {3, 5, 4};
            int [] newkoef2 = {20,4,1};
            DynArrayN<Integer> dynarr2 = new DynArrayN<>(Integer.class, nd, dm2);
            dynarr.make_newkoef();
            assertArrayEquals (dynarr2.koef_arr, newkoef2);

        }

        @Test
        public void makecord () {
            int c_abs = 778;
            int [] wait_coord = {2,1,6,2};
            int [] dm3 = {5,6,7,8};
            int nd = 4;
            DynArrayN<Integer> dynarr3 = new DynArrayN<>(Integer.class, nd, dm3);
            int [] ret_coord = dynarr3.make_cord (c_abs);
            assertArrayEquals (ret_coord, wait_coord);

            int [] wait_coord2 = {0,0,0,0};
            assertArrayEquals (dynarr3.make_cord (0), wait_coord2);

        }

        @Test
        public void makeabs () {
            int wait_abs = 778;
            int [] coord = {2,1,6,2};
            int [] coord2 = {0,0,0,0};
            int [] dm3 = {5,6,7,8};
            int nd = 4;
            DynArrayN<Integer> dynarr3 = new DynArrayN<>(Integer.class, 4, dm3);
            int  ret_abs = dynarr3.make_casb  (coord);
            assertEquals (ret_abs, wait_abs);
            assertEquals (dynarr3.make_casb(coord2), 0);
        }


}