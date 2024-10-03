public class Stack<T> {
    public Node <T> head;
    public Node <T>tail;

    public Stack() {
        head = null;
        tail = null;
        // init internal storage of stack
    }

    public int size() {
        int n = 0;

        Node<T> cur_node = this.head;

        while (cur_node != null) {
            n++;
            cur_node = cur_node.next;
        }
        return n;                    // size of current stack
    }


    public T pop() {

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
      //  return null;
    }


    public void push(T val) {

        Node<T> new_n = new Node<>(val);

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
            return this.tail.value;

        return null; // si esta vacia
    }

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



