

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

        int c1 = 0, c2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (charr[i] == '(')
                c1++;
            if (charr[i] == ')')
                c2++;
        }
        if (c1 != c2)
            return false;

        for (int i = 0; i < str.length(); i++) {
            char tmp = charr[i];

            if (tmp == '(') {
                String psh = "" + tmp;
                this.push((T) psh);
            }
            if (tmp == ')') {
                pop();
            }
        }

        if (this.size() != 0) {
            return false;
        }
        return true;
    }

//-----------------------------------------------------------------

    public boolean sbalansd (String str) {
        char[] charr = str.toCharArray();
        char strchar, lastchar = ' ';

        for (int i = 0; i < str.length(); i++) {
            strchar = charr[i];

            if (strchar == '(' | strchar == '{' | strchar == '[') {
                this.push((T) (String.valueOf(strchar)));
            } else {
                String p = (String) pop();
                if (p == null)
                    return false;

                char chpop = p.charAt(0);
                if (chpop == '(' & strchar != ')')
                    return false;
                if (chpop == '{' & strchar != '}')
                    return false;
                if (chpop == '[' & strchar != ']')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
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
    Stack<Double> stackav;

    stackcomm() {
        stackmain = new Stack<Integer> ();
        stackmin  = new Stack<Integer> ();
        stackav  = new Stack<Double> ();
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

    public void pushav (Integer val)
    {
        Double av = 0.0;
        Double oldval = (Double)this.stackav.peek();

        if (oldval == null) {
            this.stackav.push (val * 1.0);
            this.stackmain.push (val);
            return;
        }

        av = (oldval * this.stackav.size() + val) / (this.stackav.size() + 1);
        this.stackav.push (av);
        this.stackmain.push (val);
    }

    public Integer popav (Integer val)
    {
        this.stackav.pop();
        return this.stackmain.pop();

    }

    public Double averofstack() {
        return this.stackav.peek();
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
    // 8 2 + 5 * 9 + =
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








