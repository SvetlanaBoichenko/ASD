class lapareja  {
    public Integer value;
    public String key;

    lapareja(String slot, Integer val) {
        key = slot;
        value = val;
    }
}

class Node  {
    public Node next, prev;
    lapareja par;

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

    public void put (String key, Integer value)
    {
        lapareja par = new lapareja (key, value);

        Node newnod = new Node(par);

        int ascendval = -1;
        if (this._ascending) {
            ascendval = 1;
        }

        Node n;
        for (n = this.head; n != null; n = n.next){
           //  if ( newnod.par.key.compareTo(n.par.key) != ascendval) {
           int a = newnod.par.key.compareTo(n.par.key);
             if (newnod.par.key.compareTo(n.par.key) <= 0) {   //== ascendval){
                break;
            }
        }

        if (this.head == null) {
            this.head = newnod;
            this.tail = newnod; //??
            return;
        }

        if (n == null ) {
            this.tail.next = newnod;
            newnod.prev = this.tail;
            newnod.prev.next = newnod;
            this.tail = newnod;
            return;
        }
        if (n == this.head) {
            newnod.next = this.head;
            this.head.prev = newnod;
            this.head = newnod;
            return;
        }
        if (n == this.tail) {
            newnod.next = this.tail;
            newnod.prev = this.tail.prev;
            this.tail.prev.next = newnod;
            this.tail.prev = newnod;
            return;
        }
        n.prev.next = newnod;
        newnod.next = n;
        newnod.prev = n.prev;
        n.prev = newnod;
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
        Node curnod = this.head;

        for (int i = 0; i < this.size(); i++) {
            if (curnod.par.value.equals(value)) {
                return i;
            }
            curnod = curnod.next;
        }
        return -1;
    }

    public boolean isKey(String key)
    {
        return (this.getkeyindex(key) >= 0);
    }


    public static void main(String[] args) {
        String str2 = "Ana1!";
        String str3 = "Ana2333";
        int result = str2.compareTo(str2);
        System.out.println(result);
        result = str2.compareTo(str3);
        System.out.println(result);
        result = str3.compareTo(str2);
        System.out.println(result);

    }

} 


