package assign04;

import java.util.ArrayList;
import java.util.Random;

public class LargestNumberSolverTimer {
    public static void main(String[] args){
        Random randomNumberGenerator = new Random();

        // Do 100 lookups and use the average running time
        int timesToLoop = 100;

        // For each problem size n . . .
        for (int n = 100; n <= 2000; n += 100) {

            final int k = n;
            Thread t = new Thread() {
                public void run() {

                    // Generate a new arraylist for LargestNumber Solver
                    ArrayList<Integer[]> randomIntegers = new ArrayList<Integer[]>();

                    //Fill the integer arrays
                    for (int i = 0; i < k; i++) {
                        Integer[] arrayToBAdded = new Integer[20];
                        for (int j = 0; j < arrayToBAdded.length; j++) {
                            arrayToBAdded[j] = randomNumberGenerator.nextInt(100);
                        }
                        randomIntegers.add(arrayToBAdded);
                    }

                    long startTime, midpointTime, stopTime;

                    // First, spin computing stuff until one second has gone by
                    // This allows this thread to stabilize
                    startTime = System.nanoTime();
                    while (System.nanoTime() - startTime < 1000000000) { // empty block
                    }

                    // Now, run the test
                    startTime = System.nanoTime();

                    for (int i = 0; i < timesToLoop; i++)
                        // find the kth largest
                        LargestNumberSolver.findKthLargest(randomIntegers, 0);

                    midpointTime = System.nanoTime();

                    // Run a loop to capture the cost of running the "timesToLoop" loop
                    for (int i = 0; i < timesToLoop; i++) { // empty block
                    }

                    stopTime = System.nanoTime();

                    // Compute the time, subtract the cost of running the loop
                    // from the cost of running the loop and doing the lookups
                    // Average it over the number of runs
                    double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

                    System.out.println(k + ", " + averageTime);
                }
            };
            t.run();
        }
    }
}

