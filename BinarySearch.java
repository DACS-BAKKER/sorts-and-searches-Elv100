import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Elven Shum
 * Binary Search
 */


public class BinarySearch {
    private BinarySearch() {}

    private static int bSearch(int[] a, int search){
        return bSearch(a, search, 1, a.length-1);
    }

    private static int bSearch(int[] a, int search, int bot, int top){
        int mid = bot + (top-bot)/2;
        if (a[mid]==search){
            return mid;
        } else if (a[mid] > search){
            return bSearch(a, search, 1, mid-1);
        } else {            //a[mid] < search
            return bSearch(a, search, mid+1, top);
        }
    }

    public static void main(String[] args) {
        StdOut.print("Running bSearch");
        StdOut.print("input search");
        int search = StdIn.readInt();
        StdOut.print("input array");
        int[] a = StdIn.readAllInts();
        StdOut.print(bSearch(a, search));
    }
}
