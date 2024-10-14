public class Deque<T>
{
    public Node <T> head;
    public Node <T> tail;

    public Deque()
    {
        head = null;
        tail = null;
    }

     public void addFront(T item)
    {
        Node<T> new_n = new Node<>(item);
        if (this.head == null){
            this.head = new_n;
            this.head.next = null;
            this.head.prev = null;
            this.tail = new_n;
            return;
        }

        this.head.prev = new_n;
        new_n.next = this.head;
        this.head = new_n;
        this.head.prev = null;
    }

    public void addTail(T item)
    {
        Node<T> new_n = new Node<>(item);

        if (this.head == null) {
            this.head = new_n;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = new_n;
            new_n.prev = tail;
        }
        this.tail = new_n;
    }

    public T removeFront()
    {
        if (this.head == null)
            return null; // удаление из головы

        T ret = (T) this.head.value;

        if ( this.head.next == null){
            this.head = null;
            this.tail = null;
            return ret;
        }
        Node <T> tmp = this.head.next;
        tmp.prev = null;
        this.head = tmp;

        return ret;
    }

    public T removeTail()
    {
        if (this.tail == null) {
            return null;
        }

        T ret =  this.tail.value; //(T)
        this.tail = this.tail.prev;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        return ret;
    }

    public int size()
    {
        int n = 0;
        Node<T> cur_node = this.head;

        while (cur_node != null) {
            n++;
            cur_node = cur_node.next;
        }
        return n;
    }


}


class Node <T>
{
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}


