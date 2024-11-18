
class lapareja  {     // couple key_value
    public Integer value;
    public String key;

    lapareja(String slot, Integer val) {
        key = slot;
        value = val;
    }
}

class Node  {
    public Node next, prev;
    public lapareja par;

    public Node(lapareja _value) {
        par = _value;
        next = null;
    }
}

public class DictOrderedList <T extends Comparable> {//
    public Node head, tail;
    private boolean _ascending;// voshod

    public DictOrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int size()
    {   int s = 0;
        if(this.head == null)
            return 0;

        if(this.head == this.tail)
            return 1;

        for (Node n = this.head; n != this.tail; n = n.next) {
            s++;
        }
        return s;
    }

    public void AddInTail(Node newnod){

     if (this.head == null) {
        this.head = newnod;
        this.head.next = null;
        this.head.prev = null;
    } else {
        this.tail.next =  newnod;
        newnod.prev = tail;
    }
        this.tail =  newnod;
    }

    public void put (String key, Integer value)
    {
        lapareja par = new lapareja (key, value);
        Node newnod = new Node(par);

        Node curnod = null;
        for (curnod = this.head; curnod != null; curnod = curnod.next ) {
            if (curnod != null && ((this._ascending &&  key.compareTo(curnod.par.key) <= 0)
                                 || !this._ascending && key.compareTo(curnod.par.key) >= 0)) {
               break;
            }
        }

        if (curnod == null){
            this.AddInTail(newnod);
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

    public Integer get (String key) {
        for (Node n = this.head; n != this.tail; n = n.next) {
            if (n != null & n.par.key.compareTo(key) == 0){
                return (n.par.value);
            }
        }
        return null;
    }

    public int getkeyindex (String  value) {
        int i = 0;

        for (Node n = this.head; n != this.tail; n = n.next) {
            if (n.par.key.equals(value)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean isKey(String key)
    {
        for (Node n = this.head; n != this.tail; n = n.next) {
            if (n.par.key.equals(key)) {
                return true;
        }
    }
        return false;
    }


}


