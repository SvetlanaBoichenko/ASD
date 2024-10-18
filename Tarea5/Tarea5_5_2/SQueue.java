public class SQueue<T> {
    public Stack<T> stack1;
    public Stack<T> stack2;
    public SQueue() {
       this.stack1 = new Stack();
        this.stack2 = new Stack();

        this.stack1.head = null;
        this.stack1.tail = null;
        this.stack2.head = null;
        this.stack2.tail = null;
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        if (stack2.size() > 0) {
            return stack2.pop();
        }

        while(stack1.head != null)
        {
           T val = stack1.pop();
           stack2.push(val);
        }

        return stack2.pop();
    }



    public static void main(String[] args) {
    }

}

//-----------------------------------------------------------
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

//-----------------------------------------------------------
 class Stack<T> {
    public Node<T> head;
    public Node<T> tail;

    public Stack() {
        head = null;
        tail = null;
        // init internal storage of stack
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

    public int size() {
        int n = 0;

        Node<T> cur_node = this.head;
        while (cur_node != null) {
            n++;
            cur_node = cur_node.next;
        }
        return n;                    // size of current stack
    }


}
