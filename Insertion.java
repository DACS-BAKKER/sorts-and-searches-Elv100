import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {
    private Insertion() {}

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; (j > 0) && (a[j] < a[j-1]); j--) {
                swap(a, j, j-1);
            }
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
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Sorted Array:");
        Insertion.sort(a);
        show(a);
    }


}

