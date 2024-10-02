public class Stack<T> {
    public Node head;
    public Node tail;

    public Stack() {
        head = null;
        tail = null;
        // init internal storage of stack
    }

    public int size() {
        int n = 0;

        Node cur_node = this.head;

        while (cur_node != null) {
            n++;
            cur_node = cur_node.next;
        }
        return n;                    // size of current stack
    }


   public T pop() {
        T ret = null;

        if (this.tail == null) {
            return null;
        }

        ret = (T) this.tail;  //.value;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }

        return ret;
    }


    public void push(T val) {

        Node new_n = new Node (val);

        if (head == null) {
            this.head = new_n;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = new_n;
            new_n.prev = tail;
        }
        this.tail = new_n;
    }


    public T peek() {
        if (this.tail != null)
            return (T)this.tail.value;

        return null; // si esta vacia
    }
  

}


class Node<T>
{
    public T value;
    public Node next;
    public Node prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}



