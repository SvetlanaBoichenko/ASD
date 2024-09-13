import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    @Test
    public void test0() {
        LinkedList L2 = new LinkedList();
        L2.addInTail(new Node(222));

        LinkedList L3 = new LinkedList();

        // remove, count
        int wn = L3.count();
        assertTrue (wn == 0);
        assertTrue (L3.head == null);
        assertTrue (L3.tail == null);

        boolean wf = L3.remove(13);
        assertTrue (wf == false);

        L3.removeAll(13);
        wn = L3.count();
        assertTrue (wn == 0);

        L3.insertAfter(null, new Node(46));
        wn = L3.count();
        assertTrue (wn == 1);

        wn = L3.head.value;
        assertTrue (wn == 46);
        wn = L3.tail.value;
        assertTrue (wn == 46);

        L3.insertAfter(L3.tail, new Node(100));
        wn = L3.tail.value;
        assertTrue (wn == 100);
        wn = L3.head.value;
        assertTrue (wn == 46);


        LinkedList L1 = new LinkedList();
        L1.addInTail(new Node(12));
        L1.addInTail(new Node(18));
        L1.addInTail(new Node(12));
        L1.addInTail(new Node(15));
        L1.addInTail(new Node(17));
        L1.addInTail(new Node(12));

        // remove
        L1.remove(12);
        int ws = 5;
        int s = L1.count();
        assertTrue(L1.head.value == 18);
        assertTrue(L1.head.next.value == 12);
        assertTrue (ws == s);

        // removeall , find
        L1.removeAll(12);
        s = L1.count();
        ws = 3;
        assertTrue (ws == s);
        assertTrue (L1.tail.value == 17);
        assertTrue (L1.tail.next == null);

        Node wnod = L1.find(12);
        assertTrue (wnod == null);


        // insertAfter
        L1.insertAfter(null, new Node(12));
        ws = L1.count();
        int wval = L1.head.value;
        assertTrue (wval == 12);
        assertTrue (ws == 4);

        Node wnod2 = L1.find(18);
        Node wnod3 =  new Node(1112);
        L1.insertAfter(wnod2,wnod3);
        Node wnod4 = L1.find(1112);
        assertTrue (wnod3 == wnod4);

        Node wnod5 = L1.find(17);
        L1.insertAfter(L1.tail,wnod5);
        assertTrue (L1.tail == wnod5);

        Node wnod6 = new Node(12);
        L1.insertAfter(L1.tail,wnod6);
        assertTrue (L1.tail == wnod6);

        Node wnod7 = new Node(12);
        L1.insertAfter(L1.head,wnod7);
        assertTrue (L1.head.next == wnod7);


        ArrayList<Node> arr = L1.findAll(12);

        assertTrue (arr.size() == 3);

        for (int i = 0; i < arr.size(); i++){
            Node w8 =arr.get(i);
            assertTrue (w8.value == 12);
        }


        L1.removeAll(12);
        assertTrue (L1.count() == 4);


        L1.addInTail(new Node(12));
        L1.addInTail(new Node(12));
        L1.addInTail(new Node(12));
        L1.removeAll(12);
        assertTrue (L1.count() == 4);
        assertTrue (L1.tail.value == 17);

        L1.clear();
        assertTrue (L1.count() == 0);
        assertTrue (L1.head == null);
        assertTrue (L1.tail == null);


        L1.addInTail(new Node(12));
        L1.addInTail(new Node(12));
        L1.addInTail(new Node(12));
        L1.addInTail(new Node(13));
        L1.addInTail(new Node(14));
        L1.addInTail(new Node(15));
        L1.addInTail(new Node(12));
        L1.removeAll(12);
        assertTrue (L1.count() == 3);


        L1.clear();
        L1.addInTail(new Node(12));
        assertTrue (L1.count() == 1);
        assertTrue (L1.head == L1.tail);

        L1.removeAll(13);
        boolean wb = L1.remove(13);
        assertTrue (wb == false);
        wb = L1.remove(12);
        assertTrue (wb == true);

        assertTrue (L1.head == null);
        assertTrue (L1.tail == null);

        //  L1.clear();
        wb = L1.remove(19);
        assertTrue (wb == false);

        Node a = L1.find(12);
        assertTrue (a == null);

        L1.addInTail(new Node(12));
        a = L1.find(12);
        assertTrue (a == L1.head);
        assertTrue (a == L1.tail);

        a = L1.find(13);
        assertTrue (a == null);

        ArrayList<Node> arr2 = L1.findAll(14);
        assertTrue ( arr2.size() == 0);

        L1.removeAll(11);
        assertTrue ( L1.count() == 1);
        assertTrue ( L1.head.value == 12);
        assertTrue ( L1.tail.value == 12);

        L1.removeAll(12);
        assertTrue ( L1.count() == 0);
        assertTrue ( L1.head == null);
        assertTrue ( L1.tail == null);

        L1.removeAll(152);
        assertTrue ( L1.count() == 0);
        assertTrue ( L1.head == null);
        assertTrue ( L1.tail == null);



     LinkedList Ls1 = new LinkedList();
        Ls1.addInTail(new Node(12));
        Ls1.addInTail(new Node(12));
        Ls1.addInTail(new Node(13));
        Ls1.addInTail(new Node(12));
        Ls1.addInTail(new Node(12));
        Ls1.addInTail(new Node(14));
        Ls1.addInTail(new Node(15));
        Ls1.addInTail(new Node(12));

        LinkedList Ls2 = new LinkedList();
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));
        Ls2.addInTail(new Node(1));

        LinkedList Ls = new LinkedList();
                Ls = Ls.SumList(Ls1,Ls2);

        Node nw = Ls.find(13);
        assertTrue ( nw.value == 13);

        nw = Ls.find(15);
        assertTrue ( nw.value == 15);

        ArrayList<Node> AL =  Ls.findAll(13);
        assertTrue (AL.size() == 5);
        assertTrue (AL.get(0).value == 13);
        assertTrue (AL.get(1).value == 13);
       assertTrue (AL.get(2).value == 13);
        assertTrue (AL.get(3).value == 13);

        AL =  Ls.findAll(16);
        assertTrue (AL.size() == 1);
        assertTrue (AL.get(0).value == 16);

        AL =  Ls.findAll(15);
        assertTrue (AL.size() == 1);
        assertTrue (AL.get(0).value == 15);

        AL =  Ls.findAll(14);
        assertTrue (AL.size() == 1);
        assertTrue (AL.get(0).value == 14 );

        AL =  Ls.findAll(12);
        assertTrue (AL.size() == 0);
      //  assertTrue (AL.get(0).value == 11);


        LinkedList Ls31 = new LinkedList();
        LinkedList Ls32 = new LinkedList();
        LinkedList Ls33 =  new LinkedList();
            Ls33 = Ls.SumList(Ls31,Ls32);

        AL =  Ls33.findAll(12);
        assertTrue ( Ls33.count() == 0);
        assertTrue (AL.size() == 0);



        Ls31.addInTail(new Node(1));
        Ls32.addInTail(new Node(1));
        Ls33 = Ls.SumList(Ls31,Ls32);
        Node n2 = Ls33.find(2);
        assertTrue ( Ls33.count() == 1);
        assertTrue ( n2.value == 2);


    }

}
