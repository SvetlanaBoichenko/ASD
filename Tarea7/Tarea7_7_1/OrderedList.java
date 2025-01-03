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

//public class OrderedList<T>
public class OrderedList<T extends Comparable>
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
        int ret = 0;
        Class<?> cls = v1.getClass();
        if(cls.getName().equals("java.lang.Integer")) {
            ret = ((Integer) v1).compareTo((Integer) v2);
        }
        if ((cls.getName().equals("java.lang.String"))){
            ret = ((String) v1).compareTo((String) v2);
        }

        if (ret > 0)
            return 1;
        if (ret < 0)
            return -1;

        return 0;
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
        // while (curnod != null && (this.compare(value, (T) curnod.value)) == ascendval) {
       //     curnod = curnod.next;
       // }

        while (curnod != null && newnod.value.compareTo(curnod.value)== ascendval) {
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
            if (curnod.value.compareTo(val)== 0)
                return curnod;

            curnod = curnod.next;
        }
        return null; //
    }

    public void delete(T val)  {
        if (this.head == null)
            return;

        Node<T> curnod = this.head;
        if (curnod.value.compareTo(val)== 0)
        {
            this.head = curnod.next;
            if (this.head != null)
                this.head.prev = null;
            return;
        }

        curnod = this.head.next;
        while (curnod != null){
            if (curnod.value.compareTo(val)== 0){
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

    //---------------8-------------------------------------------
    public void DelDublicate() {
        Node<T> curnod = this.head;
     
        for ( Node<T> nextnod = curnod; nextnod != null; nextnod = curnod.next) {
            if (curnod.value.compareTo(curnod.next.value) == 0) {
                this.delete (curnod.next.value);
            }
            curnod = curnod.next;
        }
    }

    //----------------11----------------------------------------
    public T SumDublicate (){
        Node<T> curnod = this.head;
        Node<T> nextnod = this.head.next;

        if(curnod == null || nextnod == null)
            return null;

        int cursum = 1, oldsum = 0, maxsum = 0;
        T el = null;
        for (int i = 0; i < this.count()-1; i++) {
            if (curnod.value.compareTo(nextnod.value)== 0) {
                cursum ++;
                curnod = nextnod;
                nextnod = curnod.next;

                if (cursum > maxsum && el != curnod.value) {
                    el = curnod.value;
                }
                continue;
            }
            if (cursum > maxsum) {
                //   el = curnod.value;
                maxsum = cursum;
            }
            oldsum = cursum;
            cursum = 1;
            curnod = nextnod;
            nextnod = curnod.next;
        }

        return el;
    }

    //----------------10----------------------------
    public boolean LookForSublist (OrderedList<T> sublist) {
        Node<T> curnod = this.head;
        Node<T> subnod = sublist.head;
        boolean b = false, oldb = false;
        boolean res = false;

        if(curnod == null || subnod == null)        //|| nextnod == null)
            return b;

        while (curnod != null && subnod != null) {
            b = false;

            if (curnod.value.compareTo(subnod.value)== 0) {
                oldb = true;  // flag of first nod = subnod becaus its an ordered list
                b = true;
            }

            curnod = curnod.next;
            if (b == true && oldb == true)
                subnod = subnod.next;

            if (b == false && oldb == true)
                return false;
        }
        return b;
    }
    //-----------------OrderLists----------------------
    // funcs
    static void Insert (Node curnod, Node newnod) {
        if (curnod ==null || newnod == null)
            return;
        curnod.prev.next = newnod;
        newnod.next = curnod;
        newnod.prev = curnod.prev;
        curnod.prev = newnod;
    }

    static boolean addInTail (OrderedList<Integer> list, Node<Integer> newnod) {
        if (list.tail == null || newnod == null)
            return false;
        newnod.prev = list.tail;
        newnod.next = null;
        list.tail.next = newnod;
        list.tail = newnod;
        return true;
    }
    //------------9--------------------
    public OrderedList Orderlists (OrderedList<Integer> list1,OrderedList<Integer> list2 ) {
        Node<Integer> L1 = list1.head;
        Node<Integer> L2 = list2.head;
        OrderedList<Integer> retlist = null;

        while (L1 != null || L2 != null) {
            if (L1.value.compareTo(L2.value) < 0){
                retlist = list1;
                break;
            }
            if (list1.head.value.compareTo(list2.head.value) > 0)
            {
                L2 = list1.head;
                L1 = list2.head;
                retlist = list2;
                break;
            }
            L1 = L1.next;
            L2 = L2.next;
        }

        while (L1 != null && L2 != null) {
            if (L2.value.compareTo(L1.value) <= 0)
            {  // список 1 больше 2
                Node<Integer> newnod = new Node<> (L2.value);
                Insert(L1, newnod);
                L2 = L2.next;
                continue;
            }
            L1 = L1.next;
        }

        while (L2 != null) {
            Node<Integer> nod = new Node<>(L2.value);
            boolean b =  addInTail(retlist,nod);
            if (b == false)
                break;
            L2 = L2.next;
        }

        return retlist;
    }

    //----------------------------------------------------
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


