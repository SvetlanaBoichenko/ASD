import java.util.*;

public class LinkedList2
{
    public Dum dum;

    public LinkedList2() {
        this.dum = new Dum();
    }

    public void addInTail(Node _item)
    {
        if (this.dum.next == null) {
            this.dum.next = _item;
            _item.prev = dum;
            dum.prev = _item;
            _item.next = dum;
            return;
        }
        else {
            this.dum.prev.next = _item;
            _item.prev =  this.dum.prev;
        }
        this.dum.prev = _item;
        _item.next = dum;
    }

    public Node find(int _value)
    {
        if (this.dum.next == null)
            return null;

        Node cur_node = this.dum.next;          //.next;
        while (!(cur_node instanceof Dum)) {
            if (cur_node.value == _value)
                return cur_node;

            cur_node = cur_node.next;//.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();

        if (this.dum.next == null)
            return nodes;

        Node cur_node = this.dum.next; //.next
        for (Node n = dum.next; !(n instanceof Dum); n = n.next){

            if (cur_node.value == _value)
                nodes.add (cur_node);

            cur_node = cur_node.next;
        }
        return nodes;
    }

    public boolean remove (int _value)
    {
        if (this.dum == null | this.dum.next == null){
            return false;
        }
        Node cur_node =  this.dum.next;
        for (Node n = dum.next; !(n instanceof Dum); n = n.next){
            if (cur_node.value == _value) {
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;
                cur_node = null;
                return true;
            }
            cur_node = cur_node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if (this.dum == null || this.dum.next == null)
            return;

        Node cur_node = this.dum.next;

        Node tmp = null;
        for (Node n = dum.next; !(n instanceof Dum); n = n.next) {
            if (cur_node.value == _value){
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;

                tmp = cur_node;
                cur_node = cur_node.next;
                tmp = null;

                if (this.dum.next instanceof Dum) {
                    this.dum.next = null;
                   return;
                }
                continue;
            }
            cur_node = cur_node.next;
        }
    }

    public void clear()
    {
        this.dum.next = null;
        this.dum.prev = null;
    }

    public int count()
    {
        if (this.dum.next == null) {
            return  0;
        }

        int n = 0;
        for (Node nod = dum.next; !(nod instanceof Dum); nod = nod.next)
            n++;

        return n;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            _nodeAfter = this.dum;
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
        super(-30000);//( _value);
    }

}
