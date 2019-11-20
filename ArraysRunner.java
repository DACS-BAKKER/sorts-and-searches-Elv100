import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

//
// Elven Shum
// ArraysRUnner.java
// Testing client for timings of linked list and resizable array
//
public class ArraysRunner {

    /* min and max for data structure size */
    private static int baseSize = 16000;

    /* runner */
    public static void main(String[] args) {
        StdOut.println("Elven's Arrays Comparison Runner");
        StdOut.println("Compares LinkedList and Reziable Array Speeds");
        StdOut.println("How many increasingly-sized trials would you like?");
        int multip = StdIn.readInt();

        StdOut.println("Push Times");
        for (int i = 1; i <= multip; i++) {
            comparePush((int) (baseSize * Math.pow(2, i)));
        }
        StdOut.println("Push and Pop Times");
        for (int i = 1; i <= multip; i++) {
            comparePops((int) (baseSize * Math.pow(2, i)));
        }
    }

    private static void comparePush(int size) {
        ResizableArray theArray = new ResizableArray();
        LinkedList theList = new LinkedList<>();

        //pushes and pops ARRAY for given size
        Stopwatch resizableWatch = new Stopwatch();
        for (int i = 0; i < size; i++)
            theArray.push(0);      //some random number
        double arrayTime = resizableWatch.elapsedTime();

        //pushes and pops LIST for given size
        Stopwatch listWatch = new Stopwatch();
        for (int i = 0; i < size; i++)
            theList.push(0);
        double listTime = listWatch.elapsedTime();

        StdOut.println("size:" + size + "   arrayTime:" + arrayTime + "     listTime:" + listTime);
    }

    private static void comparePops(int size) {
        ResizableArray theArray = new ResizableArray();
        LinkedList theList = new LinkedList<>();

        //pushes and pops ARRAY for given size
        Stopwatch resizableWatch = new Stopwatch();
        for (int i = 0; i < size; i++)
            theArray.push(0);      //some random number
        for (int i = 0; i < size; i++)
            theArray.pop();
        double arrayTime = resizableWatch.elapsedTime();

        //pushes and pops LIST for given size
        Stopwatch listWatch = new Stopwatch();
        for (int i = 0; i < size; i++)
            theList.push(0);
        for (int i = 0; i < size; i++)
            theList.pop();
        double listTime = listWatch.elapsedTime();
        StdOut.println("size:" + size + "   arrayTime:" + arrayTime + "     listTime:" + listTime);
    }
}