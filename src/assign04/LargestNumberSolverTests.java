/**
 * This class tests the LargestNumberSolver class and all of its methods
 * 
 * @author Jeffrey Kjelstrom and Evan Falconer
 * @version February 8, 2023
 */

package assign04;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class LargestNumberSolverTests {

    // Fields for testing
    Random randomNums = new Random();

    Integer[] arrayOfInts;
    Integer[] arrayOfInts2;
    Integer[] arrayOfInts3;
    Integer[] arrayOfInts4;



    // InsertionSort Tests ------------------------------------------------------------------------------------
    /**
     * Test the insertion sort
     */
    @Test
    public void InsertionSortTest(){
        arrayOfInts = new Integer[]{5, 2, 6, 67, 25, 80, 100, 43};
        Comparator<Integer> intComparator = (Integer lhs, Integer rhs) -> {return lhs - rhs;};
        LargestNumberSolver.insertionSort(arrayOfInts, intComparator);
        assertArrayEquals(new Integer[]{2,5,6,25,43,67,80,100}, arrayOfInts);
    }

    /**
     * Tests the insertion sort in reverse
     */
    @Test
    public void InsertionSortTestReverse(){
        arrayOfInts = new Integer[]{100, 99, 98, 65, 34, 2, 1};
        Comparator<Integer> intComparator = (Integer lhs, Integer rhs) -> {return lhs - rhs;};
        LargestNumberSolver.insertionSort(arrayOfInts, intComparator);
        assertArrayEquals(new Integer[]{1, 2, 34, 65, 98, 99, 100}, arrayOfInts);
    }

    /**
     * Tests the inertion sort with an array that is already sorted
     */
    @Test
    public void InsertionSortTestSorted(){
        arrayOfInts = new Integer[]{1, 2, 3, 4, 5};
        Comparator<Integer> intComparator = (Integer lhs, Integer rhs) -> {return lhs - rhs;};
        LargestNumberSolver.insertionSort(arrayOfInts, intComparator);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arrayOfInts);
    }

    /**
     * Test the insertion sort with an array of all of the same integers
     */
    @Test
    public void InsertionSortTestSame(){
        arrayOfInts = new Integer[]{5, 5, 5, 5, 5};
        Comparator<Integer> intComparator = (Integer lhs, Integer rhs) -> {return lhs - rhs;};
        LargestNumberSolver.insertionSort(arrayOfInts, intComparator);
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, arrayOfInts);
    }



    // FindLargestNumber Tests ------------------------------------------------------------------------------------
    @Test
    public void FindLargestNumberTest(){
        arrayOfInts = new Integer[]{79, 7, 67, 22, 13, 11};
        assertEquals(new BigInteger("79767221311"),LargestNumberSolver.findLargestNumber(arrayOfInts));
    }

    @Test
    public void FindLargestNumberTestReverse(){
        arrayOfInts = new Integer[]{5, 4, 3, 2, 1};
        assertEquals(new BigInteger("54321"),LargestNumberSolver.findLargestNumber(arrayOfInts));
    }

    @Test
    public void FindLargestNumberTestSorted(){
        arrayOfInts = new Integer[]{1, 2, 3, 4, 5};
        assertEquals(new BigInteger("54321"),LargestNumberSolver.findLargestNumber(arrayOfInts));
    }

    @Test
    public void FindLargestNumberTestSame(){
        arrayOfInts = new Integer[]{5, 5, 5, 5, 5};
        assertEquals(new BigInteger("55555"),LargestNumberSolver.findLargestNumber(arrayOfInts));
    }

    @Test
    public void FindLargestNumberTestEmpty(){
        arrayOfInts = new Integer[]{};
        assertEquals(new BigInteger("0"),LargestNumberSolver.findLargestNumber(arrayOfInts));
    }

    // FindLargestInt Tests --------------------------------------------------------------------------------------

    @Test
    public void FindLargestNumberIntTest(){
        arrayOfInts = new Integer[]{5, 4, 3, 2, 1};
        assertEquals(54321,LargestNumberSolver.findLargestInt(arrayOfInts));
    }

    @Test
    public void FindLargestIntTestLargerThanInt() {
        arrayOfInts = new Integer[]{5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1};
        assertThrows(OutOfRangeException.class, () -> {LargestNumberSolver.findLargestInt(arrayOfInts);});
    }

    @Test
    public void FindLargestIntCanHandleLargestInt() {
        arrayOfInts = new Integer[]{2147483647};
        assertEquals(2147483647, LargestNumberSolver.findLargestInt(arrayOfInts));
    }

    // FindLargestLong Tests -------------------------------------------------------------------------------------

    @Test
    public void FindLargestNumberLongTest(){
        arrayOfInts = new Integer[]{5, 4, 3, 2, 1};
        assertEquals(54321,LargestNumberSolver.findLargestInt(arrayOfInts));
    }

    @Test
    public void FindLargestLongTestLargerThanLong() {
        arrayOfInts = new Integer[]{5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertThrows(OutOfRangeException.class, () -> {LargestNumberSolver.findLargestLong(arrayOfInts);});
    }

    // sum Tests -------------------------------------------------------------------------------------------------
    @Test
    public void sumTest(){
        arrayOfInts = new Integer[]{79, 7, 67, 22, 13, 11};
        arrayOfInts2 = new Integer[]{79, 7, 67, 22, 13, 11};
        arrayOfInts3 = new Integer[]{5, 5, 5, 5, 5};
        arrayOfInts4 = new Integer[]{5, 4, 3, 2, 1};
        ArrayList<Integer[]> listOfArrays = new ArrayList<Integer[]>();
        listOfArrays.add(arrayOfInts);
        listOfArrays.add(arrayOfInts2);
        listOfArrays.add(arrayOfInts3);
        listOfArrays.add(arrayOfInts4);
        assertEquals(new BigInteger("159534552498"), LargestNumberSolver.sum(listOfArrays));
    }
    @Test
    public void sumEmptyTest(){
        arrayOfInts = new Integer[]{};
        arrayOfInts2 = new Integer[]{};
        arrayOfInts3 = new Integer[]{};
        arrayOfInts4 = new Integer[]{};
        ArrayList<Integer[]> listOfArrays = new ArrayList<Integer[]>();
        listOfArrays.add(arrayOfInts);
        listOfArrays.add(arrayOfInts2);
        listOfArrays.add(arrayOfInts3);
        listOfArrays.add(arrayOfInts4);
        assertEquals(new BigInteger("0"), LargestNumberSolver.sum(listOfArrays));
    }

    // Find kth Tests ------------------------------------------------------------------------------------------------

    @Test
    public void testkthLargest() {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{88, 51});
        list.add(new Integer[]{92, 89, 39, 7, 21});
        list.add(new Integer[]{31, 7, 44, 11, 623, 21});
        list.add(new Integer[]{47, 73, 6});
        assertArrayEquals(new Integer[]{31, 7, 44, 11, 623, 21}, LargestNumberSolver.findKthLargest(list, 0));
    }

    @Test
    public void testkthSmallest() {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{88, 51});
        list.add(new Integer[]{92, 89, 39, 7, 21});
        list.add(new Integer[]{31, 7, 44, 11, 623, 21});
        list.add(new Integer[]{47, 73, 6});
        assertArrayEquals(new Integer[]{88, 51}, LargestNumberSolver.findKthLargest(list, 3));
    }

    @Test
    public void testkth2ndLargest() {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{88, 51});
        list.add(new Integer[]{92, 89, 39, 7, 21});
        list.add(new Integer[]{31, 7, 44, 11, 623, 21});
        list.add(new Integer[]{47, 73, 6});
        assertArrayEquals(new Integer[]{92, 89, 39, 7, 21}, LargestNumberSolver.findKthLargest(list, 1));
    }

    @Test
    public void testkth3ndLargest() {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{88, 51});
        list.add(new Integer[]{92, 89, 39, 7, 21});
        list.add(new Integer[]{31, 7, 44, 11, 623, 21});
        list.add(new Integer[]{47, 73, 6});
        assertArrayEquals(new Integer[]{47, 73, 6}, LargestNumberSolver.findKthLargest(list, 2));
    }

    // All inclusive Tests -------------------------------------------------------------------------------------------

    @Test
    public void fileReadTest(){
        List<Integer[]> bigArray = LargestNumberSolver.readFile("src/assign04/integers.txt");
        //first array
        assertArrayEquals(new Integer[]{410, 21, 93, 80, 69, 379, 20, 60, 432, 13, 72, 62, 70, 83, 9, 3, 14, 11, 62, 55, 34, 83, 80, 99, 56, 25, 79, 51, 51, 70, 79, 20, 34, 67, 40, 51, 41, 94, 89, 116, 874, 554, 137, 371, 17, 77, 97, 58, 83, 97, 26, 17, 54, 96, 33}, bigArray.get(0));
        //middle array
        assertArrayEquals(new Integer[]{88, 51}, bigArray.get(7));

        //last array
        assertArrayEquals(new Integer[]{85, 35, 34, 52, 14, 92, 9, 79, 82, 83}, bigArray.get(902));
    }

    @Test
    public void fileReadFindLargestTest(){
        List<Integer[]> bigArray = LargestNumberSolver.readFile("src/assign04/integers.txt");
        assertThrows(OutOfRangeException.class, () -> {LargestNumberSolver.findLargestLong(bigArray.get(0));});

        assertEquals(8851, LargestNumberSolver.findLargestInt(bigArray.get(7)));
    }

}
