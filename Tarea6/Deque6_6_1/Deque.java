import java.util.*;

public class Deque<T>
{
    public Node <T> head;
    public Node <T> tail;

    public Deque()
    {
        this.head = null;
        this.tail = null;
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

    
//----------SbalansS--------------------
    public boolean sbalansS (String str) {
        HashMap<Character, Character> sk = new HashMap<>();
        sk.put('(', ')');
        sk.put('[', ']');
        sk.put('{', '}');
        sk.put('<', '>');

        char[] charr = str.toCharArray();
        Character ch;

        for (int i = 0; i < str.length(); i++) {
            ch = (Character)charr[i];
            if (sk.containsKey(ch)) {
                this.addFront((T) ch);
            }
            else {
                Character p1 = (Character) this.removeFront();
                if ( p1 == null | ch != sk.get(p1))
                    return false;
            }
        }
        return true;
    }

    //----------------------------------------------------------
    public boolean ispalindrom (String str) {
        Deque<Character> dqs = new Deque<Character> ();

        for (int i = 0; i < str.length(); i++){
            Character ch = (Character)str.charAt(i);
            dqs.addTail(ch);//Character.getNumericValue(ch)
        }

        for (int i = 0; i < str.length()/2; i++){
           Character ch1 = dqs.removeFront();
           Character ch2 = dqs.removeTail();

           if (ch1.charValue() != ch2.charValue())
               return false;
        }

        return true;
    }

    
}


//------------------------------------------------------
class  Dequemin extends Deque<Integer> {
    Deque<Integer> deqmin;

    Dequemin() {
        deqmin = new Deque<>();
    }

 
    public void addFrontm(Integer item) {
        this.addFront(item);
        Integer oldmin;
        if (deqmin.head != null)
            oldmin = deqmin.tail.value;
        else {
            deqmin.addTail(item);
            return;
        }

        if (item < oldmin)
            deqmin.addTail(item);
        else {
            deqmin.addTail(oldmin);
        }
    }

    public void addTailm(Integer item) {
        this.addTail(item);

        Integer oldmin;
        if (deqmin.tail != null)
            oldmin = deqmin.tail.value;
        else {
            deqmin.addTail(item);
            return;
        }

        if (item < oldmin)
            this.deqmin.addTail(item);
        else {
            this.deqmin.addTail(oldmin);
        }
    }

    public Integer removeTailm() {
        this.deqmin.removeTail();
        return (this.removeTail());
    }

    public Integer removeFrontm() {
        this.deqmin.removeTail();
        return (this.removeFront());
    }

    public Integer minval() {
        if (this.deqmin.tail != null) {
            return ((this.deqmin.tail.value));
        }
        return null;
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


