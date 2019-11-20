import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizableArray {
    private int[] a;
    private int size;

    public ResizableArray() {
        a = new int[2];
        size = 0;
    }

    //get size
    public int size() {
        return size;
    }

    //peek
    public int peek() {
        return a[size - 1];
    }

    //push
    public void push(int n) {
        //if at threshold, double a size
        if (size == a.length) {
            resize(2 * a.length);
        }
        // push item, and inc size
        a[size++] = n;
    }

    //pop
    public int pop() {

        if (size > 0) {     //if a has items empty
            //pop val, and decrement size
            int popped = a[size - 1];
            size--;
            //account for potential size change
            if (size > 0 && size == a.length / 4) {
                resize(a.length / 2);
            }
            return popped;
        } else              //a's empty
            return Integer.parseInt(null);
    }

    //resize to new size
    private void resize(int newSize) {
        a = java.util.Arrays.copyOf(a, newSize);
    }

    private static void show(int[] a) {
        StdOut.print("[");
        for (int value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }

    public Iterator<Integer> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Integer> {
        private int i;
        public ReverseArrayIterator() {
            i = size - 1;
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public void remove() {
        }
        public Integer next() {
            return a[i--];
        }
    }
}