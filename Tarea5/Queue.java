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

    //-----------------------------------------------------------
    //N - rotate

    public Node<T> dequeue_n() {     // pop node de head

        if (this.head == null) {
            return null;
        }
        Node<T> retnode =  this.head;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }
        retnode.next = null;
        retnode.prev = null;
        return retnode;
    }

    public void enqueue_n ( Node<T> new_n) {  // push node a tail{
        if (this.head == null) {
            this.head = new_n;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = new_n;
            new_n.prev = tail;
        }
        new_n.next = null;
        this.tail = new_n;
    }

    //--------------------------------------------

    public void rotate (int nrot) {     // las vueltas
        for (int i = 0; i < nrot; i++) {
            Node<T> fnode = (Node<T>) this.dequeue_n();
            this.enqueue_n ( fnode);
        }
    }


    public Queue<T>  rotateall () {
        int n = this.size();
        Queue newque = new Queue();

        Node<T> nod =  this.tail;
        for (int i = 0; i < n; i++) {
            T curval = nod.value;
            newque.enqueue(curval);
            nod = nod.prev;
        }
        return newque;
    }


    public static void main(String[] args) {  }
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


//--------------rotate all-------------------------------------
/*
public void addtail (Node<T> node) {  //add before the head
    if (this.head == null) {
        this.head = node;
        this.head.next = null;
        this.head.prev = null;
    } else {
        this.tail.next = node;
        node.prev = tail;
    }
    this.tail = node;
    this.tail.next = null;
}

public void addafter_head (Node<T> node) {  //add before the head
    if (this.head == null) {
        return;
    }
    node.prev = this.head;
    node.next = this.head.next;
    this.head.next.prev = node;
    this.head.next = node;
}

public void add_head (Node<T> node) {  //add before the head
    if (this.head == null) {
        return;
    }
    node.prev = null;
    node.next = this.head;
    this.head.prev = node;
    this.head = node;
}

public Node<T> rethead () {   //return the tail
    if (this.head == null) {
        return null;
    }
    Node<T> ret =  this.head; //(T)

    this.head = this.head.next;
    if (this.head == null) {
        this.tail = null;
    } else {
        this.head.prev = null;
    }
    return ret;
}

public Node<T> rettail () {   //return the tail
    if (this.tail == null) {
        return null;
    }
    Node<T> ret =  this.tail; //(T)

    this.tail = this.tail.prev;
    if (this.tail == null) {
        this.head = null;
    } else {
        this.tail.next = null;
    }
    return ret;
}
*/