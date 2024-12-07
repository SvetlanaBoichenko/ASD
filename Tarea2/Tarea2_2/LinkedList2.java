import java.util.*;

public class LinkedList2
{
    public Dum dum1;
    public Dum dum2;

    public LinkedList2() {
        this.dum1 = new Dum();
        this.dum2 = new Dum();
    };

    public void addInTail(Node _item)
    {
        if (this.dum1.next == null) {
            this.dum1.next = _item;
            _item.prev = dum1;
        }
        else {
            this.dum2.prev.next = _item;
            _item.prev =  this.dum2.prev;
        }
        this.dum2.prev = _item;
        _item.next = dum2;
    }

    public Node find(int _value)
    {
        if (this.dum1.next == null)
            return null;

        Node cur_node = this.dum1.next;          //.next;
        while (cur_node!= dum2 && cur_node != dum1) {
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
        for (Node n = dum1.next; n != dum2; n = n.next){
            if (cur_node.value == _value)
                nodes.add (cur_node);

            cur_node = cur_node.next;
        }
        return nodes;
    }

    public boolean remove (int _value)
    {
        if (this.dum1 == null | this.dum1.next == null){
            return false;
        }
        Node cur_node =  this.dum1.next;
        for (Node n = dum1.next; n != dum2; n = n.next){
            if (cur_node.value == _value) {
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;
                cur_node = null;
                if (dum1.next == dum2) {
                    dum2.prev = null;
                    dum1.next = null;
                }
                return true;
            }
            cur_node = cur_node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if (this.dum1 == null | this.dum1.next == null)
            return;
        Node cur_node = this.dum1.next;

        Node tmp = null;
        for (Node n = dum1.next; n != dum2; n = n.next) {
            if (cur_node.value == _value){
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;

                tmp = cur_node;
                cur_node = cur_node.next;
                tmp = null;

                if (this.dum1.next == dum2) {
                    this.dum2.prev = null;
                    this.dum1.next = null;
                    return;
                }
                continue;
            }
            cur_node = cur_node.next;
        }
    }

    public void clear()
    {
        this.dum1.next = null;
        this.dum2.prev = null;
    }

    public int count()
    {
        if (this.dum1.next == null) {
            return  0;
        }

        int n = 0;
        for (Node nod = dum1.next; nod != dum2; nod = nod.next)
            n++;

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
    }

}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node (int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

class Dum  extends Node
{
    public Dum() {
        super(0);//( _value);
    }

}
