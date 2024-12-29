package OrderedList;
import java.lang.*;

class keyindex  {     // couple key_index
    public int index;
    public String key;

    keyindex (String slot) {
        key = slot;
        index = 0;
    }
}


class Node
{
    keyindex value;
    public Node next, prev;

    public Node (keyindex _par)
    {
        value = _par;
        next = null;
        prev = null;
    }
}
/*
можно сделать чтобы add (key) сразу возвращал индекс ключа например.
Вот какая идея в целом:
- когда добавляем пару ключ-значение, значение добавляется в хвост values
- ключ вставляется в slots с сохранением сортировки, но не один ключ,
а список/кортежи(ключ, индекс), где индекс указывает на позицию соответствующего значения в values.

Внутри упорядоченного списка соответственно надо будет переопределить операцию сравнения ключей
 (которая фактически остаётся такой как есть, только обращаемся к узлу не напрямую например key,
  а к его первому элементу).*/


public class OrderedList <T extends Comparable>  {
    public Node head, tail;
    private boolean _ascending;// voshod

    public OrderedList(boolean asc) {
        this.head = null;
        this.tail = null;
        _ascending = asc;
    }

    public void add (String value, int index)
    {
        Node  newnod = new Node (new keyindex(value));//

        if (this.head == null) {
            this.head = newnod;
            this.tail = head; //??
            return;
        }

        Node curnod  = null;
        for (curnod = this.head;  curnod != null;  curnod = curnod.next)
        {
            if (curnod != null && ((this._ascending &&  value.compareTo ( curnod.value.key) >= 0)
                    || !this._ascending && value.compareTo( curnod.value.key) <= 0)) {

                newnod.value.index = index;
                break;
            }
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

        Node tmp = curnod.next;
        curnod.next = newnod;
        newnod.prev = curnod;
        newnod.next = tmp;
        tmp.prev = newnod;
        return;
    }

    public int count()
    {
        int s = 0;
        for (Node n = this.head; n != null; n = n.next) {
            s++;
        }
        return s;
    }

    public void delete(String val)
    {
        if (this.head == null)
            return;
        if (this.head.next == null){
            this.head = null;
            this.tail = null;
            return;
        }

        Node curnod =  this.head;
        if (curnod.value.key.compareTo(val) == 0)
        {
            this.head = curnod.next;
            this.head.prev = null;
            return;
        }

        curnod = this.head.next;
        while (curnod != null){
            if (curnod.value.key.compareTo(val) == 0) {
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


    public int getkeyindex (String  value) {
       Node curnod = this.head;

        for (int i = 0; i < this.count(); i++) {
            if (curnod.value.key.compareTo(value) == 0) {
                return curnod.value.index;
            }
            curnod = curnod.next;
        }
        return -1;
    }
}

