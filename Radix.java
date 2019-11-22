import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Elven Shum
 * Radix Sort
 */


public class Radix {
    public Radix() {}

    private static void countSort(int[] a, int exp) {
        int[] finalArray = new int[a.length];
        int[] count = new int[10];

        //tracks the how many of each digit.
        for (int i = 0; i < a.length; i++)
            count[(a[i] / exp) % 10]++;

        //sums each digit's occurances
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        //constructs array
        for (int i = a.length - 1; i >= 0; i--) {
            finalArray[count[(a[i] / exp) % 10] - 1] = a[i];
            // Increment count by -1
            count[(a[i] / exp) % 10]--;
        }

        // duplicates finalArray into a
        System.arraycopy(finalArray, 0, a, 0, a.length);
    }

    public static void sort(int[] a) {
        //find maximum
        int maxIndx = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] > a[maxIndx])
                maxIndx = i;
        int max = a[maxIndx];


        for (int i = 1; max / i > 0; i *= 10)
            countSort(a, i);
    }

    private static void show(int[] a) {
        StdOut.print("[");
        for (int value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }

    public static void main(String[] args) {
        StdOut.print("Running Radix");
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Sorted Array:");
        Radix.sort(a);
        show(a);
    }
}
