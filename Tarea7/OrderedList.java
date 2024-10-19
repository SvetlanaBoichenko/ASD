import java.util.*;

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

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;// voshod

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        return ((Integer) v1).compareTo((Integer) v2);
    }

    public void add(T value)
    {
        Node<T> newnod = new Node<>(value);
        Node<T> curnod = this.head;

        if (curnod == null) {
            this.head = newnod;
            this.tail = head; //??
            return;
        }

        int ascendval = -1;
        if (this._ascending) {
            ascendval = 1;
        }

        while (curnod != null && (this.compare(value, (T) curnod.value)) == ascendval) {
               curnod = curnod.next;
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

        curnod.prev.next = newnod;
        newnod.next = curnod;
        newnod.prev = curnod.prev;
        curnod.prev = newnod;
        return;
    }


    public Node<T> find(T val)
    {
        Node<T> curnod = this.head;
        while (curnod != null) {
            if (compare((T) curnod.value, val) == 0)
                return curnod;

            curnod = curnod.next;
        }
        return null; //
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


        Node<T> curnod = this.head;
        if (compare((T) curnod.value, val) == 0)
        {
            this.head = curnod.next;
            this.head.prev = null;
            return;
        }

        curnod = this.head.next;
        while (curnod != null){
            if (compare((T) (curnod.value), val) == 0){
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

    public void clear(boolean asc)
    {
        this.head = null;
        this.tail = null;
        _ascending = asc;
    }

    public int count()
    {
        Node <T> curnod = this.head;
        int n = 0;
        while (curnod != null) {
            curnod = curnod.next;
            n++;
        }
        return n;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    
} 


