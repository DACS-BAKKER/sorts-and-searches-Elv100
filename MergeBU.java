import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeBU {
    private MergeBU() {
    }

    ;

    //merges the array together
    //lower half of a[] is sorted, upper half of a[] is sorted
    private static void merge(int[] a, int[] copy, int bot, int mid, int top) {
        // copies a[] to copy[]
        for (int k = bot; k <= top; k++) {
            copy[k] = a[k];
        }

        // MERGES top and bottom from copy[] to a[]
        int lowerTrav = bot;
        int upperTrav = mid + 1;
        for (int k = bot; k <= top; k++) {
            if (lowerTrav > mid) {
                a[k] = copy[upperTrav++];        //when lower arr is exhausted, take from upper
            } else if (upperTrav > top) {
                a[k] = copy[lowerTrav++];        //when upper arr is exhausted, take from lower
            } else if (copy[upperTrav] < copy[lowerTrav]) {    //following two deal with std comparisons
                a[k] = copy[upperTrav++];
            } else {
                a[k] = copy[lowerTrav++];
            }
        }
    }

    public static void sort(int[] a) {
        int n = a.length;
        int[] copy = new int[n];
        for (int len = 1; len < n; len *= 2) {                  //current Length of sort
            for (int bot = 0; bot < n - len; bot += 2 * len) {       //determines indexes
                int mid = bot + len - 1;
                int top = Math.min(bot + 2 * len - 1, n - 1);
                merge(a, copy, bot, mid, top);
            }
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
        StdOut.print("Running Merge Bottom Up");
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Sorted Array:");
        MergeBU.sort(a);
        show(a);
    }
}