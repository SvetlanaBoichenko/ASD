import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class LinkedList2Test {
    @Test
    public void test0() {
        LinkedList2 L1 = new LinkedList2();
        L1.addInTail(new Node(2));
        L1.addInTail(new Node(1));
        L1.addInTail(new Node(2));
        L1.addInTail(new Node(3));
        L1.addInTail(new Node(4));
        L1.addInTail(new Node(5));
        L1.addInTail(new Node(6));
        L1.addInTail(new Node(7));
        L1.addInTail(new Node(4));
        L1.addInTail(new Node(8));

        Node n1 = L1.find(1);
        assertTrue(n1 != null);
        assertTrue(n1.value == 1);

        n1 = L1.find(2);
        assertTrue(n1 != null);
        assertTrue(n1.value == 2);
        n1 = L1.find(3);
        assertTrue(n1 != null);
        assertTrue(n1.value == 3);
        n1 = L1.find(4);
        assertTrue(n1 != null);
        assertTrue(n1.value == 4);
        n1 = L1.find(5);
        assertTrue(n1 != null);
        assertTrue(n1.value == 5);
        n1 = L1.find(6);
        assertTrue(n1 != null);
        assertTrue(n1.value == 6);
        n1 = L1.find(7);
        assertTrue(n1 != null);
        assertTrue(n1.value == 7);
        n1 = L1.find(8);
        assertTrue(n1 != null);
        assertTrue(n1.value == 8);

        n1 = L1.find(16);
        assertTrue(n1 == null);

        n1 = L1.find(-30000);
        assertTrue(n1 == null);

        LinkedList2 L2 = new LinkedList2();
        L2.addInTail(new Node(10));

        n1 = L2.find(10);
        assertTrue(n1 != null);
        assertTrue(n1.value == 10);
        n1 = L2.find(17);
        assertTrue(n1 == null);

        ArrayList<Node> nodes2 = new ArrayList<Node>();
        L1.addInTail(new Node(2));
        L1.addInTail(new Node(2));
        nodes2 = L1.findAll(2);
        assertTrue(nodes2 != null);
        assertTrue(nodes2.size() == 4);
        assertTrue(nodes2.get(0).value == 2);
        assertTrue(nodes2.get(1).value == 2);
        assertTrue(nodes2.get(2).value == 2);
        assertTrue(nodes2.get(3).value == 2);

        L1.addInTail(new Node(4));
        nodes2 = L1.findAll(4);
        assertTrue(nodes2 != null);
        assertTrue(nodes2.size() == 3);
        assertTrue(nodes2.get(0).value == 4);
        assertTrue(nodes2.get(1).value == 4);
        assertTrue(nodes2.get(2).value == 4);

        nodes2 = null;
        nodes2 = L2.findAll(10);
        assertTrue(nodes2 != null);
        assertTrue(nodes2.size() == 1);
        assertTrue(nodes2.get(0).value == 10);

        nodes2 = null;
        nodes2 = L2.findAll(11);
        assertTrue(nodes2.size() == 0);
    }

    @Test
    public void test1() {
        LinkedList2 L11 = new LinkedList2();
        L11.addInTail(new Node(12));
        L11.addInTail(new Node(18));
        L11.addInTail(new Node(12));
        L11.addInTail(new Node(15));
        L11.addInTail(new Node(17));
        L11.addInTail(new Node(12));

        // remove
        L11.remove(12);
        int ws = 5;
        int s = L11.count();
        assertTrue(L11.dum.next.value == 18);

        //  assertTrue(L11.head.next.value == 12);
        assertTrue (ws == s);

        // removeall , find
        L11.removeAll(12);
        s = L11.count();
        ws = 3;
        assertTrue (ws == s);
  
        Node wnod = L11.find(12);
        assertTrue (wnod == null);


        // insertAfter
        L11.insertAfter(null, new Node(12));
        ws = L11.count();
        int wval = L11.dum.next.value;
        assertTrue (wval == 12);
        assertTrue (ws == 4);

        Node wnod2 = L11.find(18);
        Node wnod3 =  new Node(1112);
        L11.insertAfter(wnod2,wnod3);
        Node wnod4 = L11.find(1112);
        assertTrue (wnod3 == wnod4);

        Node wnod5 = L11.find(17);
        L11.insertAfter(wnod5, new Node(17));
  
        Node wnod6 = new Node(12);
       L11.insertAfter(L11.dum.prev,wnod6);
  
        Node wnod7 = new Node(12);
        L11.insertAfter(L11.dum.next,wnod7);
        assertTrue (L11.dum.next.next == wnod7);
        assertTrue (wnod7.prev == L11.dum.next);
        assertTrue (wnod7.next.prev == wnod7);


        ArrayList<Node> arr = L11.findAll(12);

        assertTrue (arr.size() == 3);

        for (int i = 0; i < arr.size(); i++){
            Node w8 =arr.get(i);
            assertTrue (w8.value == 12);
        }

        L11.removeAll(12);
        assertTrue (L11.count() == 5);

        L11.addInTail(new Node(12));
        L11.addInTail(new Node(12));
        L11.addInTail(new Node(12));
        L11.removeAll(12);
        assertTrue (L11.count() == 5);
   

        L11.clear();
        assertTrue (L11.count() == 0);
        assertTrue (L11.dum.next == null);
 
        L11.addInTail(new Node(12));
        L11.addInTail(new Node(12));
        L11.addInTail(new Node(12));
        L11.addInTail(new Node(13));
        L11.addInTail(new Node(14));
        L11.addInTail(new Node(15));
        L11.addInTail(new Node(12));
        int n = L11.count();
        assertTrue (n == 7);

        L11.removeAll(12);
        assertTrue (L11.count() == 3);

        L11.clear();
        L11.addInTail(new Node(12));
        assertTrue (L11.count() == 1);
  
        L11.removeAll(13);
        boolean wb = L11.remove(13);
        assertTrue (wb == false);
        wb = L11.remove(12);
        assertTrue (wb == true);


        wb = L11.remove(19);
        assertTrue (wb == false);

        Node a = L11.find(12);
        assertTrue (a == null);

        L11.addInTail(new Node(12));
        a = L11.find(12);
        assertTrue (a == L11.dum.next);
  

        a = L11.find(13);
        assertTrue (a == null);

        ArrayList<Node> arr2 = L11.findAll(14);
        assertTrue ( arr2.size() == 0);

        L11.removeAll(11);
        assertTrue ( L11.count() == 1);
        assertTrue ( L11.dum.next.value == 12);
  

        L11.removeAll(12);
        assertTrue ( L11.count() == 0);
        assertTrue ( L11.dum.next == null);
    

        L11.removeAll(152);
        assertTrue ( L11.count() == 0);
        assertTrue ( L11.dum.next == null);
  

        int c =  L11.count();
        assertTrue (c == 0);
    }
}
