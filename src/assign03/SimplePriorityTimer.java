package assign03;

import assign03.SimplePriorityQueue;
import assign03.PriorityQueue;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.util.Random;

public class SimplePriorityTimer {
    public static void main(String[] args){
        Random randomNumberGenerator = new Random();

        // Do 10000 lookups and use the average running time
        int timesToLoop = 10000;

        // For each problem size n . . .
        for (int n = 100000; n <= 2000000; n += 100000) {

            // Generate a new SimplePriorityQueue class
            SimplePriorityQueue<Integer> randomIntegers = new SimplePriorityQueue<Integer>();

            long startTime, midpointTime, stopTime;

            // First, spin computing stuff until one second has gone by
            // This allows this thread to stabilize
            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            // Now, run the test
            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++)
                // find the max
                for (int j = 0; j < n; j++)
                    randomIntegers.insert(randomNumberGenerator.nextInt(n));

            midpointTime = System.nanoTime();

            // Run a loop to capture the cost of running the "timesToLoop" loop
            for (int i = 0; i < timesToLoop; i++) { // empty block
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and doing the lookups
            // Average it over the number of runs
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

            System.out.println(n + "\t" + averageTime);

        }
    }
}
