package OList;
import java.lang.*;
import java.util.ArrayList;

class cort {        //<T extends Comparable>
    String val1;
    String val2;
     cort (String val1, String val2) {
        if (val1.compareTo(val2) <= 0){
            this.val1 = val1;
            this.val2 = val2;
        }
        else {
            this.val1 = val2;
            this.val2 = val1;
        }
    }
}


class Node
{
    cort value;
    public Node next, prev;

    public Node (cort _par)
    {
        value = _par;
        next = null;
        prev = null;
    }
}


public class OList  {
    public Node head, tail;
    private boolean _ascending;// voshod

    public OList () {
        this.head = null;
        this.tail = null;

    }

    public void add (String value1, String value2)
    {
        cort value = new cort (value1, value2);
        Node  _item = new Node (value);//

        if (this.head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public ArrayList<Node> getAll()
    {
        ArrayList<Node> r = new ArrayList<Node>();
        Node node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public int count()
    {
        int s = 0;
        for (Node n = this.head; n != null; n = n.next) {
            s++;
        }
        return s;
    }

    public void delete(Node rnode)
    {
       if (rnode == null)
           return;

        if (rnode == this.head) {
            Node tmp = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            tmp = null;
            return;
        }

        if (rnode == this.tail) {
            tail = rnode.prev;
            tail.next = null;
            rnode = null;
            return;
        }

            rnode.prev.next = rnode.next;
            rnode.next.prev = rnode.prev;
            rnode = null;
    }


 
}

