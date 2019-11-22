import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Elven Shum
 * Quick Sort
 */


public class Quick {
    private Quick() {}

    public static void sort(int[] a) {
        randomize(a);
        show(a);
        sort(a, 0, a.length - 1);
    }

    public static void randomize(int [] a){
        int size = a.length;
        for (int i=0; i<size; i++) {
            int randomPosition = (int) (Math.random()*size);
            int temp = a[i];
            a[i] = a[randomPosition];
            a[randomPosition] = temp;
        }
    }
    // quicksort the subarray from a[bot] to a[top]
    private static void sort(int[] a, int bot, int top) {
        if (top <= bot) return;
        int j = partition(a, bot, top);
        sort(a, bot, j-1);
        sort(a, j+1, top);

    }

    // partition the subarray a[bot..top] so that a[bot..j-1] <= a[j] <= a[j+1..top]
    // and return the index j.
    private static int partition(int[] a, int bot, int top) {
        int i = bot;
        int j = top + 1;
        int v = a[bot];
        while (true) {

            // find item on bot to swap
            while (a[++i] < v) {
                if (i == top) break;
            }

            // find item on top to swap
            while (v < a[--j]) {
                if (j == bot) break;      // redundant since a[bot] acts as sentinel
            }

            if (i >= j) break;          //if pointers cross, break entire loop
            swap(a, i, j);
        }
        // put partitioning item v at a[j]
        swap(a, bot, j);
        // now, a[bot .. j-1] <= a[j] <= a[j+1 .. top]
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(int[] a) {
        StdOut.print("[");
        for (int value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }

    public static void main(String[] args) {
        StdOut.print("Running Quick");
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Randomized Array:");
        Quick.sort(a);
        StdOut.print("Sorted Array:");
        show(a);
    }
}
