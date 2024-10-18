import java.util.*;

public class ArrQueue {
    public int head;
    public int tail;
    Integer[] arr;
    int count;
    int capacity;

    public ArrQueue(int N) {
        this.head = 0;
        this.tail = 0;
        this.arr = new Integer [N];
        this.count = 0;
        this.capacity = N;
    }

    public void enqueue(Integer item) {
        int pos = this.tail;
        if (this.count >= this.capacity)
            return;

        if (pos > this.capacity-1)
            pos = 0;

        if (pos > tail)
            return;

        this.arr[pos] = item;
        this.count++;
        pos++;
        this.tail = pos;
    }


    public Integer dequeue() {
        Integer ret = null;
        ret = this.arr[head];
        this.arr[head] = null;
        this.head = this.head + 1;

        this.count--;
        return ret;
    }


    public static void main(String[] args) {
    }
}



