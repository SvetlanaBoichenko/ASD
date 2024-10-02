
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
        Node ret = this.tail;

        if (ret != null) {
            this.tail = this.tail.prev;
        } else {
            return (T) ret;
        }

        if (this.tail != null){
            this.tail.next = null;
        }
        else {
            this.head = null;
        }

        return (T) ret;
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
            return (T)this.tail;

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



