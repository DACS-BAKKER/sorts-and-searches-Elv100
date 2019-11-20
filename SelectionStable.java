import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SelectionStable {
    private SelectionStable() {}


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
            slide(a, i, min);
        }
    }

    //slides min to the i'th position, moving all others up to fill space.
    private static void slide(int[] a, int i, int j) {
        int curr = i+1;
        int temp1 = a[i];
        int temp2 = a[curr];
        a[i] = a[j];
        while(curr <= j){
            //rotates thru, until curr == j-1
            a[curr] = temp1;
            temp1 = temp2;
            temp2 = a[curr+1];
            curr++;
        }
    }

    private static void show(int[] a) {
        StdOut.print("[");
        for (int value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }

    public static void main(String[] args) {
        StdOut.print("Running StableSelection");
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Sorted Array:");
        Insertion.sort(a);
        show(a);
    }
}
