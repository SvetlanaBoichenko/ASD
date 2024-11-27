import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        if(this.head == null)
            return null;

        if (this.head.next == null && this.head.value == _value) { //1 el
            return this.head;
        }
        if (this.head.next == null){
            return null;
        }

        Node cur_node = this.head;          //.next;
        while (cur_node != null) {
            if (cur_node.value == _value)
                return cur_node;

            cur_node = cur_node.next;//.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();

        if(this.head == null)
            return nodes;

        if (this.head.next == null && this.head.value == _value) { //1 el
            nodes.add(this.head);
            return (nodes);
        }
        if (this.head.next == null){
            return nodes;
        }

        Node cur_node = this.head; //.next
        while (cur_node != null) {

            if (cur_node.value == _value)
                nodes.add (cur_node);

            cur_node = cur_node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        if (this.head == null)
            return false;

        if (this.head.next == null && head.value == _value) { //1 el
            this.head = null;
            this.tail = null;
            return true;
        }
        if ( this.head.next == null){
            return false;
        }
        if (this.head.value == _value) {
            Node tmp = head;
            this.head = this.head.next;
            this.head.prev = null;
            tmp = null;
            return true;
        }

        Node cur_node = this.head.next;          //.next;
        while (cur_node != null) {
            if (cur_node.value == _value) {
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;

                if (cur_node == tail)
                    tail = cur_node.prev;

                cur_node = null;
                return true;
            }
            cur_node = cur_node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if(this.head == null)
            return;

        if (this.head.next == null && head.value == _value) { //1 el
            this.head = null;
            this.tail = null;
            return;
        }
        if  (this.head.next == null) {
            return;
        }

        Node cur_node = this.head;          //.next;
        Node tmp = null;

        while (cur_node != null) {
            if (this.head.value == _value) {
                tmp = head;
                this.head = this.head.next;
                this.head.prev = null;
                cur_node = cur_node.next;
                tmp = null;
                continue;
            }
            if (cur_node.value == _value && cur_node == tail) {
                tail = cur_node.prev;
                tail.next = null;
                cur_node = null;
                break;
            }
            if (cur_node.value == _value){
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;

                tmp = cur_node;
                cur_node = cur_node.next;
                tmp = null;
                continue;
            }
            cur_node = cur_node.next;
        }
    }

    public void clear()
    {
        if(this.head == null) {
            this.tail = null;
            return;
        }
        if (this.head.next == null){
            this.head =  null;
            this.tail = null;
            return;
        }
        Node next_node = head.next;

        while (head.next != null) {
            next_node = head.next;
            head = next_node;
        }
        head = null;
        tail.prev = null;
        tail = null;
    }

    public int count()
    {
        if (this.head == null) {
            return  0;
        }
        if (this.head.next == null){
            return 1;
        }

        int n = 1; // head!= 0

        Node cur_node = this.head.next;
        while (cur_node != null) {
            n++;
            cur_node = cur_node.next;
        }
        return n;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (this.head == null && _nodeAfter == null) {
            this.head = _nodeToInsert;
            _nodeToInsert.next = null;
            tail = _nodeToInsert;
            return;
        }
        if (_nodeAfter == null) {       // _nodeAfter
            this.head.prev = _nodeToInsert;
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            this.head.prev = null;
            return;
        }
        if (this.head == _nodeAfter && this.head.next != null) {  // after head, prev = nullthis.head.next.prev = _nodeToInsert;
            _nodeToInsert.prev = this.head;
            _nodeToInsert.next = this.head.next;
            _nodeToInsert.next.prev =  _nodeToInsert;
            this.head.next = _nodeToInsert;
            return;
        }
        if (this.head == _nodeAfter) {  // after head, prev = null
            _nodeToInsert.prev = head;
            this.head.next = _nodeToInsert;
            _nodeToInsert.next = null;
            tail = _nodeToInsert;
            return;
        }
        if (_nodeAfter == tail){
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            _nodeToInsert.next = null;
            tail = _nodeToInsert;
            return;
        }

        Node cur_node = this.head.next;
        while (cur_node != null) {

            if(cur_node ==_nodeAfter) {
                _nodeToInsert.prev = cur_node;
                _nodeToInsert.next = cur_node.next;
                cur_node.next.prev = _nodeToInsert;
                cur_node.next = _nodeToInsert;
                return;
            }
            cur_node = cur_node.next;
        }
    }
//-------------9*---------------------------------
    public void rotatelist () {
        Node n1 = this.head;
        Node n2 = this.tail;

        int k = this.count()/2;
        for (int i = 0 ; i < k; i++) {
            int tmp = n1.value;
            n1.value = n2.value;
            n2.value = tmp;

            n1 = n1.next;
            n2 = n2.prev;
        }
    }
    //-----------------for 11-------------------
    public LinkedList2 moveminvalue (Node curnod, LinkedList2 retlist)
    {
        for (Node n = retlist.head; n != null; n = n.next) {
            if (curnod.value <= n.value) {
                retlist.insertAfter(n.prev,curnod);
                return retlist;
            }
        }
        retlist.addInTail(curnod);
        return retlist;
    }
//------------------11*-----------------------------
    public void Sortlist () {
        LinkedList2 sortlist = new LinkedList2();
        for (Node n = this.head; n != null; n = n.next) {
            Node nx = new Node(n.value);
            sortlist = moveminvalue (nx, sortlist);
        }

        Node snod = sortlist.head;
        for (Node n = this.head; n != null; n = n.next) {
            n.value = snod.value;
            snod = snod.next;
        }
         sortlist.clear();
    }

    //- ---------12*---------------------------------------------
    public LinkedList2  unitlists (LinkedList2 L2) {
          L2.Sortlist();
          this.Sortlist();
          Node n1= this.head;

        LinkedList2 retList = new LinkedList2();
        for (Node n2 = L2.head; n2 != null; n2 = n2.next) {
            Node n3 = new Node(n2.value);
            retList = moveminvalue (n3, this);
            }
        return retList;
    }

    public static void main(String[] args) { }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node (int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}


