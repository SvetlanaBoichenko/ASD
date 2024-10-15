import java.util.*;

public class Stack<T> {
    public Node<T> head;
    public Node<T> tail;

    public Stack() {
        boolean isaval1 = false;
        head = null;
        tail = null;
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

        T ret = this.tail.value; //(T)
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

//----------------------------------------------------------
    public boolean sbalans (String str) {
          char[] charr = str.toCharArray();
        if (charr[0] == ')')
            return false;

        for (int i = 0; i < str.length(); i++) {
            char tmp = charr[i];

            if (tmp == '(') {
                Character psh = tmp;
                this.push((T) psh);
            }
            if (tmp == ')') {
                Character p = (Character) this.pop();
                if (p == null)
                        return false;
            }
        }

        if (this.size() != 0) {
            return false;
        }
        return true;
    }

//-----------------------------------------------------------------
    public boolean sbalansd (String str) {
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
                this.push((T) ch);
            }
            else {
                Character p1 = (Character) this.pop();
                if ( p1 == null | ch != sk.get(p1))
                    return false;
            }
        }
        return true;
    }
}

class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }

}


//----------------------------------------------------------------------
class stackcomm
{
    Stack<Integer> stackmain;
    Stack<Integer> stackmin;
    Double Sumav;

    stackcomm() {
        stackmain = new Stack<Integer> ();
        stackmin  = new Stack<Integer> ();
        Sumav  = 0.0;
    }

    public void pushav (Integer val)
    {
        Double av = 0.0;
        Sumav = (Sumav * this.stackmain.size() + val) / (this.stackmain.size() + 1);
        this.stackmain.push (val);
    }

    public Integer popav ()
    {
        Sumav = (Sumav * this.stackmain.size() - this.stackmain.peek()) / (this.stackmain.size()-1);
        return this.stackmain.pop();
    }

    public Double averofstack() {
        return this.Sumav;
    }

    public void pushm (Integer val)
    {
        Integer oldval =  (Integer)this.stackmin.peek();
        if (oldval == null) {
            stackmin.push(val);
            stackmain.push(val);
            return;
        }
        if (oldval < val)
            this.stackmin.push(oldval);
        else
            this.stackmin.push(val);

        stackmain.push(val);
    }

    public Integer popm(Integer val)
    {
        this.stackmin.pop();
        return this.stackmain.pop();
    }

    public Integer minofstack() {
        return this.stackmin.peek();
    }


}


//-----------------------------------------------------------------
class stackpostfix {

    Stack<Integer> stacknum;
    Stack<String> stackdata;

    stackpostfix() {
        stacknum = new Stack<Integer>();
        stackdata = new Stack<String>();
    }

    public Integer result(Stack stackdata) {
        boolean isnum;
        Integer n1, n2, res = 0, retres = 0;
        String s = "";
        int size = stackdata.size();

        for (int i = 0; i < size; i++) {
            isnum = true;
            String rstr = (String) stackdata.pop();

            for (int j = 0; j < rstr.length() ; j++) {
                char ch = rstr.charAt(j);
                if (ch == ' ')
                    break;
                if (Character.isDigit(ch)) {
                    s += ch;
                } else {
                    isnum = false;
                    break;
                }
            }

            if (isnum) {
                n1 = Integer.valueOf(rstr);
                stacknum.push(n1);
                s = "";
            } else {
                n1 =  stacknum.pop();
                n2 =  stacknum.pop();

                if ((n1== null | n2 == null) & rstr != "=")
                    return null;

                if (rstr == "+") {
                    res = (n1 + n2);
                    stacknum.push(res);
                    continue;

                }
                if (rstr == "*") {
                    res = (n1 * n2);
                    stacknum.push(res);
                    continue;
                }
                if (rstr == "-") {
                    res = (n1 - n2);
                    stacknum.push(res);
                    continue;
                }

                if (rstr == "=") {
                    retres = res;
                        break;
                }
            }
        }
        return retres;
    }
}









