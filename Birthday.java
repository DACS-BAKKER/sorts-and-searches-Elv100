import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Elven Shum
 * Birthday Problem
 * (with discussion with Alex Yuk)
 */

public class Birthday {
    private Birthday() {}

    public static void main(String[] args) {
        int N;
        int reps;

        System.out.print("How many elements N would you like\n? ");
        N = StdIn.readInt();
        System.out.print("How many repetitions would you like\n? ");
        reps = StdIn.readInt();
        int counter = 0;
        for (int i = 0; i < reps; i++) {
            boolean[] birthday = new boolean[N];
            boolean isRepeated = false;
            while (!isRepeated) {
                counter++;
                int r = (int) (Math.random() * N);
                if (birthday[r])
                    isRepeated = true;
                else
                    birthday[r] = true;
            }
        }

        StdOut.println("Experimental: " + (double) counter / reps);
        StdOut.println("Theoretical: " + Math.sqrt(N * Math.PI / 2));
    }
}

