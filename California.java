import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/*
 * Elven Shum
 * California Problem
 * "Alternative Alphabetizing"
 */

public class California {
    private California() { }
//
//    merges the array together
//    lower half of a[] is sorted, upper half of a[] is sorted
    private static void merge(String[] a, String[] copy, int bot, int mid, int top) {
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
            } else if (isLess(copy[upperTrav], copy[lowerTrav])) {    //following two deal with std comparisons
                a[k] = copy[upperTrav++];
            } else {
                a[k] = copy[lowerTrav++];
            }
        }
    }

    private static boolean isLess(String fir, String sec) {
        int firVal = -2, secVal = -1;
        int firLeng = fir.length(), secLeng = sec.length();
        int currChar = 0;
        String[] order = {"R", "W", "Q", "O", "J", "M", "V", "A", "H", "B", "S", "G", "Z", "X"
                , "N", "T", "C", "I", "E", "K", "U", "P", "D", "Y", "F", "L"};
        do{
            if(firLeng == currChar || secLeng == currChar) {
                    return firLeng<secLeng;
                }
            for(int i = 0; i < order.length; i++){
                if (order[i].equals(fir.substring(currChar, currChar + 1))) {
                    firVal = i;
                    break;
                }
            }
            for(int i = 0; i < order.length; i++){
                if (order[i].equals(sec.substring(currChar, currChar + 1))) {
                    secVal = i;
                    break;
                }
            }
            currChar++;
        } while (firVal == secVal);
        return firVal < secVal;


    }



    public static void sort(String[] a) {
        int n = a.length;
        String[] copy = new String[n];
        for (int len = 1; len < n; len *= 2) {                  //current Length of sort
            for (int bot = 0; bot < n - len; bot += 2 * len) {       //determines indexes
                int mid = bot + len - 1;
                int top = Math.min(bot + 2 * len - 1, n - 1);
                merge(a, copy, bot, mid, top);
            }
        }
    }



    private static void show(String[] a) {
        StdOut.print("[");
        for (String value : a) {
            StdOut.print(value + " ");
        }
        StdOut.println("]");
    }


    public static void main(String[] args) {
        StdOut.print("Running California (bottom up merge)");
        String[] a = StdIn.readAllStrings();
        show(a);
        StdOut.print("Sorted Array:");
        sort(a);
        show(a);
    }
}




//            firVal = -2;
//            secVal = -1;
//            for(int i = 0; i < order.length; i++) {
//                if (firLeng == currChar || secLeng == currChar) {
//                    StdOut.println("first:"+ firVal+"  secVal:"+secVal );
//                    StdOut.println("firstLeg:"+ firLeng+"  secLeg:"+secLeng );
//                    StdOut.println("currChar:"+ currChar);
//                    break outerloop;
//                }
//                if (order[i].equals(fir.substring(currChar, currChar + 1))) {firVal = i;}
//                if (order[i].equals(sec.substring(currChar, currChar + 1))) {secVal = i;}
//                StdOut.println("Order: "+order[i]);
//                StdOut.println("firSub: "+fir.substring(currChar, currChar + 1));
//                StdOut.println("secSub: "+sec.substring(currChar, currChar + 1));
//                StdOut.println("currChar:"+ currChar);
//                StdOut.println("firVal:" + firVal);
//                StdOut.println("secVal:" + secVal);
//                if(firVal == secVal){
//                    StdOut.println("BREAK");
//                    break;      //Breaks out of AlphabetOrder arr, to move to next Char of fir,sec
//                }
//            }
//            currChar++;