import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    
    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    
    public int count() {
        Node cur_node = head;
        int ret = 0;
        while (cur_node != null) {
            ret++;
            cur_node = cur_node.next;
        }

        return ret;
    }


    public LinkedList SumList (LinkedList L1, LinkedList L2) {
        if (L1.count() != L2.count()) return null;

        Node n1 = L1.head;
        Node n2 = L2.head;
        int vav1, val2;
        LinkedList  Ls = new LinkedList();
     
        for (int i = 0; i < L1.count(); i++ ) {
           
            Node ns = new Node( n1.value + n2.value);       
            Ls.addInTail(ns);
            n1 = n1.next;
            n2 = n2.next;         
        }

        return Ls;
    }

 
}



class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}


