import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;
    public int nodecount;

    public LinkedList2() {
        head = null;
        tail = null;
       this.nodecount = 0;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        this.nodecount++;
    }

    public Node find(int _value) {
        if (this.head == null)
            return null;

        if (this.head.next == null && this.head.value == _value) { //1 el
            return this.head;
        }
        if (this.head.next == null) {
            return null;
        }

        Node cur_node = this.head;          //.next;
        while (cur_node != null) {
            if (cur_node.value == _value)
                return cur_node;

            cur_node = cur_node.next;//.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        if (this.head == null)
            return nodes;

        if (this.head.next == null && this.head.value == _value) { //1 el
            nodes.add(this.head);
            return (nodes);
        }
        if (this.head.next == null) {
            return nodes;
        }

        Node cur_node = this.head; //.next
        while (cur_node != null) {

            if (cur_node.value == _value)
                nodes.add(cur_node);

            cur_node = cur_node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.head == null)
            return false;

        if (this.head.next == null && head.value == _value) { //1 el
            this.head = null;
            this.tail = null;
            this.nodecount = 0;
            return true;
        }
        if (this.head.next == null) {
            return false;
        }
        if (this.head.value == _value) {
            Node tmp = head;
            this.head = this.head.next;
            this.head.prev = null;
            tmp = null;
            this.nodecount--;
         //   if (nodecount < 0) nodecount = 0;
            return true;
        }

        Node cur_node = this.head.next;          //.next;

        while (cur_node != null) {
            if (cur_node == tail) {
                this.tail = cur_node.prev;
                this.tail.next = null;
                this.nodecount--;
                return true;
            }
            if (cur_node.value == _value) {
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;

                cur_node = null;
                this.nodecount--;
                return true;
            }
            cur_node = cur_node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        if (this.head == null)
            return;

        if (this.head.next == null && head.value == _value) { //1 el
            this.head = null;
            this.tail = null;
            this.nodecount --;
            return;
        }
        if (this.head.next == null) {
         //   this.nodecount = 0;
            return;
        }

        Node cur_node = this.head;          //.next;
        Node tmp = null;

        while (cur_node != null) {
            if (this.head.value == _value) {
                tmp = head;
                this.head = this.head.next;
                this.head.prev = null;
                cur_node = cur_node.next;
                tmp = null;
                this.nodecount --;
                continue;
            }
            if (cur_node.value == _value && cur_node == tail) {
                tail = cur_node.prev;
                tail.next = null;
                this.nodecount --;
                cur_node = null;
                break;
            }
            if (cur_node.value == _value) {
                cur_node.prev.next = cur_node.next;
                cur_node.next.prev = cur_node.prev;

                tmp = cur_node;
                cur_node = cur_node.next;
                tmp = null;
                this.nodecount --;
                continue;
            }
            cur_node = cur_node.next;
        }
    }

    public void clear() {
        this.nodecount = 0;
        if (this.head == null) {
            this.tail = null;
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
            return;
        }
        Node next_node = head.next;

        while (head.next != null) {
            next_node = head.next;
            head = next_node;
        }
        head = null;
        tail.prev = null;
        tail = null;
    }

    public int count() {
        if (this.head == null) {
            return 0;
        }
        if (this.head.next == null) {
            return 1;
        }

        int n = 1; // head!= 0

        Node cur_node = this.head.next;
        while (cur_node != null ) { //null
            n++;
            if (cur_node == this.tail)
                break;
            cur_node = cur_node.next;

        }
        return n;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (this.head == null && _nodeAfter == null) {
            this.head = _nodeToInsert;
            _nodeToInsert.next = null;
            tail = _nodeToInsert;
            this.nodecount++;
            return;
        }
        if (_nodeAfter == null) {       // _nodeAfter
            this.head.prev = _nodeToInsert;
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            this.head.prev = null;
            this.nodecount ++;
            return;
        }
        if (this.head == _nodeAfter && this.head.next != null) {  // after head, prev = nullthis.head.next.prev = _nodeToInsert;
            _nodeToInsert.prev = this.head;
            _nodeToInsert.next = this.head.next;
            _nodeToInsert.next.prev = _nodeToInsert;
            this.head.next = _nodeToInsert;
            this.nodecount++;
            return;
        }
        if (this.head == _nodeAfter) {  // after head, prev = null
            _nodeToInsert.prev = head;
            this.head.next = _nodeToInsert;
            _nodeToInsert.next = null;
            tail = _nodeToInsert;
            this.nodecount++;
            return;
        }
        if (_nodeAfter == tail) {
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            _nodeToInsert.next = null;
            tail = _nodeToInsert;
            this.nodecount++;
            return;
        }

        Node cur_node = this.head.next;
        while (cur_node != null) {

            if (cur_node == _nodeAfter) {
                _nodeToInsert.prev = cur_node;
                _nodeToInsert.next = cur_node.next;
                cur_node.next.prev = _nodeToInsert;
                cur_node.next = _nodeToInsert;
                this.nodecount++;
                return;
            }
            cur_node = cur_node.next;
        }
    }

    //-------------9*---------------------------------
    //  Лучше... использовать готовые методы добавления/удаления узлов
    public void rotatelist() {
        Node n1 = this.head;
        Node n2 = this.tail;

        int k = this.count() / 2;
        for (int i = 0; i < k; i++) {
            int tmp = n1.value;
            n1.value = n2.value;
            n2.value = tmp;

            n1 = n1.next;
            n2 = n2.prev;
        }
    }

    //-----------9 with ---change nodes--------------------------------------
    public void rotatelist2() {
        Node n1 = this.head;
        Node n2 = this.tail;

        int k = this.count() / 2;
        for (int i = 0; i < k; i++) {
            Node tmp1 = new Node(n1.value);
            Node tmp2 = new Node(n2.value);
            Node tmp1prev = n1.prev;
            Node tmp2prev = n2.prev;

            this.remove(n2.value);
            this.insertAfter(tmp1prev, tmp2);
            this.insertAfter(tmp2prev, tmp1);
            this.remove(n1.value);

            n1 = tmp2.next;
            n2 = tmp1.prev;
        }
    }

    //-----------9 with -add nodes--------------------------------------
    public void rotatelist3() {

        Node n = this.tail;
        LinkedList2 rlist = new LinkedList2();

        int k = this.count();
        for (int i = 0; i < k; i++) {
            Node tmp = new Node(n.value);
            rlist.addInTail(tmp);
            n = n.prev;
        }

        this.head = rlist.head;
        this.tail = rlist.tail;
    }

    //-----------remove nodes for 9--------------------------------------
    public void removenode (LinkedList2 Ls, Node n){
        Node tmp1 = n;

        if (n == this.head) {
            this.head = n.next;
            n = null;
            return;
        }
        if (n == this.tail) {
            n.prev = this.tail;
            this.tail.next = null;
            n = null;
            return;
        }
        n.prev.next = n.next;
        n.next.prev =  n.prev;
        n = null;
    }
    //-------------9*---rotatelist4----------------------------------

    public void rotatelist4() {
        Node n1 = this.head;
        Node n2 = this.tail;

        int k = this.count() / 2;
        for (int i = 0; i < k; i++) {
            Node tmp1 = new Node (n1.value);
            Node tmp2 = new Node (n2.value);

            this.insertAfter(n1.prev, tmp2);
            this.insertAfter(n2.prev, tmp1);
            this.removenode(this, n1);
            this.removenode(this, n2);

            n1 = tmp2.next;
            n2 = tmp1.prev;
        }
    }

    //------------------11*-----------------------------
    public void Sortlist() {
        LinkedList2 sortlist = new LinkedList2();

        for (Node n1 = this.head; n1 != null; n1 = n1.next) {
            Node nx = new Node(n1.value);
            boolean b = false;
            for (Node n = sortlist.head; n != null; n = n.next) {
                if (nx.value <= n.value) {
                    sortlist.insertAfter(n.prev, nx);
                    b = true;
                    break;
                }
            }
            if (!b) {
                sortlist.addInTail(nx);
            }
        }

        this.head = sortlist.head;
        this.tail = sortlist.tail;
    }

    //------------------11 sort value bubles*-----------------------------
    public void Sortlist2() {

        boolean shift = true;
        int count = this.count();

        while (shift) {
            shift = false;
            Node a1 = this.head;
            Node a2 = a1.next;

            for (int i = 0; i < count; i++) {
                if (a1 == null || a2 == null) break;

                if (a1.value > a2.value) {
                    int tmp = a1.value;
                    a1.value = a2.value;
                    a2.value = tmp;

                    shift = true;
                }
                a1 = a1.next;
                a2 = a2.next;
            }
            count--;
        }
    }

    //------------------change nodes for 11-----------------------------
    public void changenods (LinkedList2 Ls, Node n1, Node n2){
        Node tmp1 = n1;

        if (n1 == Ls.head) {
            Ls.head = n1.next;
            n1 = null;
        }
        else {
            n1.prev.next = n1.next;
            n1.next.prev =  n1.prev;
            n1 = null;
        }
        this.insertAfter(n2, tmp1);
    }
    //------------------11 sort node bubles*-----------------------------
    public void Sortlist3() {

        boolean shift = true;
        int count = this.count();

        while (shift) {
            shift = false;
            Node a1 = this.head;
            Node a2 = a1.next;

            for (int i = 0; i < count; i++) {
                if (a1 == null || a2 == null) break;

                if (a1.value > a2.value) {
                    this.changenods(this, a1, a2);
                    shift = true;
                    a2 = a1.next;
                }
                else {
                    // a2 = a1;
                    a1 = a1.next;
                    a2 = a2.next;
                }
            }
            count--;
        }
    }
    //-----------------for 12-------------------
    public LinkedList2 addminvalue(Node curnod, LinkedList2 retlist) {
        for (Node n = retlist.head; n != null; n = n.next) {
            if (curnod.value <= n.value) {
                retlist.insertAfter(n.prev, curnod);
                return retlist;
            }
        }
        retlist.addInTail(curnod);
        return retlist;
    }

    //----------12*---------------------------------------------
    public LinkedList2 unitlists(LinkedList2 L2) {
        L2.Sortlist();
        this.Sortlist();
        Node n1 = this.head;

        LinkedList2 retList = new LinkedList2();
        for (Node n2 = L2.head; n2 != null; n2 = n2.next) {
            Node n3 = new Node(n2.value);
            retList = addminvalue(n3, this);
        }
        return retList;
    }

      //----------12**---------------------------------------------
 static   public LinkedList2 unitlists2(LinkedList2 L1, LinkedList2 L2) {
        L2.Sortlist2();
        L1.Sortlist2();
        LinkedList2 retList = new LinkedList2();

        Node n1 = L1.head;
        Node n2 = L2.head;

        while (!(n1 == null && n2 == null)) {

            if (n2 == null) {
                Node t = new Node(n1.value);
                retList.addInTail(t);
                n1 = n1.next;
                continue;
            }
            if (n1 == null) {
                Node t = new Node(n2.value);
                retList.addInTail(t);
                n2 = n2.next;
                continue;
            }
            if (n1.value == n2.value) {
                Node t1 = new Node(n1.value);
                Node t2 = new Node(n2.value);
                retList.addInTail(t1);
                retList.addInTail(t2);
                n1 = n1.next;
                n2 = n2.next;
                continue;
            }
            if (n1.value < n2.value) {
                Node t = new Node(n1.value);
                retList.addInTail(t);
                n1 = n1.next;
                continue;
            }
            Node t = new Node(n2.value);
            retList.addInTail(t);
            n2 = n2.next;
        }

        return retList;
    }

    //------------------12.3-***---------------------------
   static public LinkedList2 unitNlists (LinkedList2[] NList) {
        LinkedList2 L1 = NList[0];
        LinkedList2 L2 = null;

        for (int i = 1; i < NList.length; i++) {
            L2 = new LinkedList2();
            L2 = unitlists2 (L1, NList[i]);
            L1.clear();
            L1.head = L2.head;
            L1.tail = L2.tail;
        }
        return L2;
    }

    //---------------10------is-cikl-2---------------
    public boolean iscicle2() {
        if ( this.nodecount == 0)
            return false;

        Node nx = this.head;

        for (int i = 0; i < this.nodecount-1; i++) {
            nx = nx.next;
        }
        return !(nx == this.tail);
    }

    //----------------is-cikl3----------------
    public boolean iscicle3() {
        Node nx2 = this.head;

        // while(true)
        for (int i = 0; i < this.nodecount-1; i++) {
            nx2 = nx2.next;

            if(nx2.next == null)
                break;

            if (nx2 != nx2.next.prev)
                return true;
        }
        return false;
    }

    //----------------is-cikl----------------
    public boolean iscicle() {
        Node nx2 = this.head;
        Node nx3 = nx2;

        while (nx2 != null && nx3 != null) {
            nx3 = nx3.next;

            if (nx2 == nx3)
                return true;

            if (nx3 == this.tail) {
                nx2 = nx2.next;
                nx3 = nx2.next;
            }

            if (nx2 == tail) break;
        }
        return false;
    }
}

//--------------------------
class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node (int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
