import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Elven Shum
 * Selection Sort
 */


public class Selection {
    private Selection() {}


    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            //finds index of smallest num
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[j]<a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(int[] a) {
        StdOut.print("[");
        for (int value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }

    public static void main(String[] args) {
        StdOut.print("Running Selection");
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Sorted Array:");
        Insertion.sort(a);
        show(a);
    }
}
