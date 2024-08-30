import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node cur_node = head;
        while (cur_node != null) {
            if (cur_node.value == _value) {
                Node f_node = cur_node;
                nodes.add(f_node);
            }
            cur_node = cur_node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {

        if (count() == 1 && head.value == _value) {
            clear();
            return true;
        }

        Node prev_node = null;
        Node cur_node = head;

        while (cur_node != null) {
            if (cur_node.value == _value & prev_node != null) {
                prev_node.next = cur_node.next;

                if (cur_node.next == null) {
                    tail = prev_node;
                }
                cur_node = null;
                return true;        // deleted
            }

            if (cur_node.value == _value) {
                head = cur_node.next;
                cur_node = null;
                return true;
            }
            prev_node = cur_node;
            cur_node = prev_node.next;
        }
        return false;
    }


    public void removeAll(int _value) {
        Node prev_node = null;
        Node cur_node = head;

        while (cur_node != null) {

            if (cur_node.value == _value & prev_node != null) {
                prev_node.next = cur_node.next;

                if (cur_node.next == null) {
                    tail = prev_node;
                }
                cur_node = null;
                cur_node = prev_node.next;
                continue;
            }

            if (cur_node.value == _value && cur_node == tail){  //prev_node == null
                clear();
                break;
            }

            if (cur_node.value == _value)  {         //prev_node == null
                head = cur_node.next;
                cur_node = null;
                cur_node = head;
                continue;
            }

            prev_node = cur_node;
            cur_node = prev_node.next;
        }
    }


    public void clear() {
        Node next_node = head.next;

        while (head.next != null) {
            next_node = head.next;
            head = next_node;
        }
        head = null;
        tail = null;
    }


    public int count() {
        Node cur_node = head;
        int ret = 0;
        while (cur_node != null) {
            ret++;
            cur_node = cur_node.next;
        }

        return ret;
    }


    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        Node tmp = null;

        if (count() == 0) {
            head = _nodeToInsert;
            tail = _nodeToInsert;
            return;
        }

        if (_nodeAfter == tail) {
            tail = _nodeToInsert;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
            return;
        }

        Node cur_node = head;
        while (cur_node != null) {
            if (cur_node == _nodeAfter) {
                tmp = cur_node.next;
                cur_node.next = _nodeToInsert;
                _nodeToInsert.next = tmp;
                return;
            }
            cur_node = cur_node.next;
        }
    }

  
}


   class Node {
     public int value;
     public Node next;

     public Node(int _value) {
     value = _value;
     next = null;
    }
}





