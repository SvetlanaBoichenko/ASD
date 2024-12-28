package OrderedList;
import java.lang.*;
class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList <T extends Comparable>  {
    public Node <T> head, tail;
    private boolean _ascending;// voshod

    public OrderedList(boolean asc) {
        this.head = null;
        this.tail = null;
        _ascending = asc;
    }

    public void add(T value)
    {
        Node<T> newnod = new Node<T>(value);

        if (this.head == null) {
            this.head = newnod;
            this.tail = head; //??
            return;
        }

        Node<T> curnod  = null;
        for (curnod = this.head;  curnod != null;  curnod = curnod.next)
        {
            if (curnod != null && ((this._ascending &&  value.compareTo ( curnod.value) >= 0)
                    || !this._ascending && value.compareTo( curnod.value) <= 0))
                break;

           // curnod = curnod.next;
        }

        if (curnod == null) {
            this.tail.next = newnod;
            newnod.prev = this.tail;
            this.tail = newnod;
            return;
        }
        if (curnod == this.head) {
            newnod.next = this.head;
            this.head.prev = newnod;
            this.head = newnod;
            return;
        }
        if (curnod == this.tail) {
            newnod.next = this.tail;
            newnod.prev = this.tail.prev;
            this.tail.prev.next = newnod;
            this.tail.prev = newnod;
            return;
        }

        Node tmp = curnod.next;
        curnod.next = newnod;
        newnod.prev = curnod;
        newnod.next = tmp;
        tmp.prev = newnod;
    }

    public int count()
    {
        int s = 0;
        for (Node n = this.head; n != null; n = n.next) {
            s++;
        }
        return s;
    }

    public void delete(T val)
    {
        if (this.head == null)
            return;
        if (this.head.next == null){
            this.head = null;
            this.tail = null;
            return;
        }

        Node<T> curnod =  this.head;
        if (curnod.value.compareTo(val) == 0)
        {
            this.head = curnod.next;
            this.head.prev = null;
            return;
        }

        curnod = this.head.next;
        while (curnod != null){
            if (curnod.value.compareTo(val) == 0) {
                break;
            }
            curnod = curnod.next;
        }

        if (curnod == this.tail){
            this.tail = this.tail.prev;
            this.tail.next = null;
            return;
        }
        if (curnod != null) {
            curnod.prev.next = curnod.next;
            curnod.next.prev = curnod.prev;
        }
    }


    public int getkeyindex (T  value) {
       Node<T> curnod = this.head;

        for (int i = 0; i < this.count(); i++) {
            if (curnod.value.compareTo(value) == 0) {
                return i;
            }
            curnod = curnod.next;
        }
        return -1;
    }
}

