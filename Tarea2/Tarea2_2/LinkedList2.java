import java.util.*;

class dum
{
    public Node dum1 = new Node(0);
    public Node dum2 = new Node(0);
}

public class LinkedList2 extends dum
{
     public Node head;
     public Node tail;

 public LinkedList2() {

    this.head = null;
    this.tail = null;

  }

public void addInTail(Node _item)
{
    if (dum1.next == null) {

        dum1.next = _item;
        _item.prev = this.dum1;
        this.dum1.next = _item;
    } else {
        this.dum2.prev.next = _item;
        _item.prev = dum2.prev;
    }

    _item.next = this.dum2;
    this.dum2.prev = _item;

    this.tail = dum2.prev;
    this.head = dum1.next;
}

    public Node find(int _value)
    {
        if (this.dum1.next == null)
            return null;

        Node cur_node = this.dum1.next;          //.next;

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

        if (this.dum1.next == null)
            return nodes;

        Node cur_node = this.dum1.next; //.next
        while (cur_node != null & cur_node != this.dum2) {
            if (cur_node.value == _value)
                nodes.add (cur_node);

            cur_node = cur_node.next;
        }
        return nodes;
    }


     public boolean remove (int _value) {
        Node cur_node =  dum1.next;         //;this.head;// bsv

        if (this.count() == 1 &&  cur_node.value == _value) {
            this.dum1.next = null;
            this.dum2.prev = null;
            this.tail = dum2.prev;
            this.head = dum1.next;
            return true;
        }

        while (cur_node != dum2 && cur_node!= null) {
            if (cur_node.value == _value) {
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;
                cur_node = null;
                this.tail = dum2.prev;
                this.head = dum1.next;
                return true;
            }
            cur_node = cur_node.next;
        }
        return false;
    }


    public void removeAll(int _value)
    {
        Node cur_node = this.dum1.next;          //.next;

        if (this.count() == 1 &&  cur_node.value == _value) {
            this.dum1.next = null;
            this.dum2.prev = null;
            this.tail = dum2.prev;
            this.head = dum1.next;
            return;
        }

        Node tmp = null;
        while (cur_node != null & cur_node != dum2) {
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
        this.tail = dum2.prev;
        this.head = dum1.next;
    }


    public void clear()
    {
        if (this.dum1.next == null) {
            this.dum2.prev = null;
            this.tail = dum2.prev;
            this.head = dum1.next;
            return;
        }

        Node next_node = null;

        while (dum1.next != null) {
            next_node = dum1.next;
            dum1.next = null;
            dum1.next = next_node.next;
        }
        dum2.prev = null;
        this.tail = dum2.prev;
        this.head = dum1.next;
    }


    public int count()
    {
        if (this.dum1.next == null) {
            return  0;
        }

        int n = 0;
        Node cur_node = dum1.next;

        while (cur_node != dum2) {
            n++;
            cur_node = cur_node.next;

        }
        return n;
    }


    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            _nodeAfter = this.dum1;
        }
        _nodeAfter.next.prev = _nodeToInsert;
        _nodeToInsert.next = _nodeAfter.next;

        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;

        this.tail = dum2.prev;
        this.head = dum1.next;
    }

    public static void main(String[] args) {

    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}