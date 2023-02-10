/**
 * This class include methods that are used to find the largest number of a conbination of a given list of integer values
 * 
 * @author Jeffrey Kjelstrom and Evan Falconer
 * @version February 8, 2023
 */

package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumberSolver {
    /**
     * Sorts a given array using the given Comparator object
     * @param <T> object type
     * @param arr array to sort
     * @param cmp Comparator class
     * @see Comparator
     */
    public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp){
        // Loops through each of the items
        for (int i = 1; i < arr.length; i++){
            int j = i;
            // compares each item to one another
            while (j > 0 && (cmp.compare(arr[j], arr[j-1]) < 0)){
                // swap
                T temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    /**
     * Finds the largest number created by a combination of the numbers in the list and returns it of type BigInteger
     * @param arr array of integers
     * @return largest number
     * @see BigInteger
     */
    public static BigInteger findLargestNumber(Integer[] arr){
        // case for empty array
        if (arr.length == 0)
            return new BigInteger("0");

        // making comparator
        Comparator<Integer> intComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String lhs = o1 + "" + o2;
                String rhs = o2 + "" + o1;
                return Integer.parseInt(lhs) - Integer.parseInt(rhs);
            }
        };

        // sorting
        Integer[] array = arr.clone();
        insertionSort(array, intComparator);
        StringBuilder bigNum = new StringBuilder("");
        for(int i = array.length-1; i >= 0; i--){
            bigNum.append(array[i]);
        }

        // final return
        return new BigInteger(bigNum.substring(0));
    }

    /**
     * Finds the largest number created by a combination of the numbers in the list and 
     * returns it of type int, if it can fit into the size limit of an int
     * @param arr array of integers
     * @return largest number
     * @throws OutOfRangeException
     */
    public static int findLargestInt(Integer[] arr) throws OutOfRangeException{
        // case for empty array
        if (arr.length == 0)
            return 0;

        // making comparator
        Comparator<Integer> intComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String lhs = o1 + "" + o2;
                String rhs = o2 + "" + o1;
                return Integer.parseInt(lhs) - Integer.parseInt(rhs);
            }
        };

        // sorting
        Integer[] array = arr.clone();
        insertionSort(array, intComparator);
        StringBuilder bigNum = new StringBuilder("");
        for(int i = array.length-1; i >= 0; i--){
            bigNum.append(array[i]);
        }

        // Checks if the number of outside of the range of an int
        BigInteger num = new BigInteger(bigNum.substring(0));
        if (num.compareTo(new BigInteger(2147483647 + "")) > 0) {
            throw new OutOfRangeException("number too big for type int");
        }

        // Converts the number to a string
        String number = bigNum.toString();

        // final return
        return Integer.parseInt(number);
    }

    /**
     * Finds the largest number created by a combination of the numbers in the list and 
     * returns it of type long, if it can fit into the size limit of an long
     * @param arr array of integers
     * @return largest number
     * @throws OutOfRangeException
     */
    public static long findLargestLong(Integer[] arr) throws OutOfRangeException{
        // case for empty array
        if (arr.length == 0)
            return 0;

        // making comparator
        Comparator<Integer> intComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String lhs = o1 + "" + o2;
                String rhs = o2 + "" + o1;
                return Integer.parseInt(lhs) - Integer.parseInt(rhs);
            }
        };

        // sorting
        Integer[] array = arr.clone();
        insertionSort(array, intComparator);
        StringBuilder bigNum = new StringBuilder("");
        for(int i = array.length-1; i >= 0; i--){
            bigNum.append(array[i]);
        }

        // Checks if number is outside of range of long
        BigInteger num = new BigInteger(bigNum.substring(0));
        if (num.compareTo(new BigInteger("9223372036854775807")) > 0) {
            throw new OutOfRangeException("number too big for type int");
        }

        // Converts number to string
        String number = bigNum.toString();

        // final return
        return Integer.parseInt(number);
    }

    /**
     * Sums the largest numbers that can be formed by each array in the given list
     * @param list
     * @return sum of largest numbers
     */
    public static BigInteger sum(List<Integer[]> list){
        //create a sum
        BigInteger sum = new BigInteger("0");
        //make loop
        for (Integer[] e : list){
        // in loop call findLargestNumber and add it to sum
            sum = sum.add(findLargestNumber(e));
        }
        return sum;
    }

    /**
     * Finds the kth largest number out of the arrays given in the list
     * @param list
     * @param k index to find
     * @return list of kth largest integers
     * @throws IllegalArgumentException
     */
    public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException{

        if (k > list.size() - 1) {
            throw new IllegalArgumentException("K is out of range for list");
        }

        Integer[][] numbers = list.toArray(new Integer[0][]);
        insertionSort(numbers, (Integer[] nums1, Integer[] nums2) -> {
            BigInteger num1 = findLargestNumber(nums1);
            BigInteger num2 = findLargestNumber(nums2);

            return num1.compareTo(num2);
        });
        return numbers[numbers.length - k - 1];
    }

    /**
     * Generates list of integer arrays from an input file
     * @param filename
     * @return list of integer arrays
     */
    public static List<Integer[]> readFile(String filename){
        // Creates a lit of integer arrays
        ArrayList<Integer[]> listOfInts = new ArrayList<Integer[]>();
        try {
            // Reads file
            Scanner fileIn = new Scanner (new File(filename));

            // Adds numbers to list
            while (fileIn.hasNextLine()){
                String nums = fileIn.nextLine();
                String[] numbers = nums.split(" ");
                Integer[] lineInts = new Integer[numbers.length];

                for (int i = 0; i < lineInts.length; i++){
                    lineInts[i] = Integer.parseInt(numbers[i]);
                }
                listOfInts.add(lineInts);

            }

            fileIn.close();
            return listOfInts;
        }
        catch(FileNotFoundException e) {
            System.err.println(e.getMessage() + "No Integer list created.");
            return null;
        }
    }
}
