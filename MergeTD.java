import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeTD {
    private MergeTD() {}

    //merges the array together
    //lower half of a[] is sorted, upper half of a[] is sorted
    private static void merge(int[] a, int[] copy, int bot, int mid, int top) {
        // copies a[] to copy[]
        for (int k = bot; k <= top; k++) {
            copy[k] = a[k];
        }

        // MERGES top and bottom from copy[] to a[]
        int lowerTrav = bot;
        int upperTrav = mid+1;
        for (int k = bot; k <= top; k++) {
            if (lowerTrav > mid) {
                a[k] = copy[upperTrav++];        //when lower arr is exhausted, take from upper
            } else if (upperTrav > top){
                a[k] = copy[lowerTrav++];        //when upper arr is exhausted, take from lower
            } else if (copy[upperTrav] < copy[lowerTrav]){    //following two deal with std comparisons
                a[k] = copy[upperTrav++];
            } else {
                a[k] = copy[lowerTrav++];
            }
        }
    }

    private static void sort(int[] a, int[] copy, int bot, int top) {
        if (top <= bot) return;         //checks to see if only looking at 1
        int mid = bot + (top - bot) / 2;
        sort(a, copy, bot, mid);
        sort(a, copy, mid + 1, top);
        merge(a, copy, bot, mid, top);
    }

    public static void initSort(int[] a) {
        int[] copy = new int[a.length];
        sort(a, copy, 0, a.length - 1);
    }


    private static void show(int[] a) {
        StdOut.print("[");
        for (int value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }


    public static void main(String[] args) {
        StdOut.print("Running Merge Top Down");
        int[] a = StdIn.readAllInts();
        show(a);
        StdOut.print("Sorted Array:");
        MergeTD.initSort(a);
        show(a);
    }

}
