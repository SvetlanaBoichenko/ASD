public class Queue<T>
{
    public Node <T> head;
    public Node <T>tail;

    public  Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(T item)
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

    public T dequeue()
    {
        if (this.head == null) {
            return null;
        }
        T ret =  this.head.value; //
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
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


class Node<T>
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


