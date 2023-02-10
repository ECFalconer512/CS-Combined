package assign03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SimplePriorityTests {
    private SimplePriorityQueue<String> StringQueue;
    private ArrayList<String> listOfStrings = new ArrayList<String>();

    @BeforeEach
    void setUp() throws Exception{
        StringQueue = new SimplePriorityQueue<String>();
    }
    // findMax() tests ------------------------------------------------------------------------------------------------
    @Test
    public void testfindMax(){
        StringQueue.insert("hi");
        StringQueue.insert("howdy");
        StringQueue.insert("heya");
        StringQueue.insert("hello");
        assertEquals("howdy", StringQueue.findMax());
    }

    @Test
    public void testEmptyFindmax(){
        assertThrows(NoSuchElementException.class, ()-> {StringQueue.findMax();});
    }
    // deleteMax() tests ----------------------------------------------------------------------------------------------
    @Test
    public void testDeleteMax(){
        StringQueue.insert("hi");
        StringQueue.insert("howdy");
        StringQueue.insert("heya");
        StringQueue.insert("hello");
        assertEquals("howdy", StringQueue.deleteMax());
        assertEquals("hi", StringQueue.findMax());
    }

    @Test
    public void testDeleteEmptyMax(){
        assertThrows(NoSuchElementException.class, ()-> {StringQueue.deleteMax();});
    }

    // insert() tests -------------------------------------------------------------------------------------------------
    @Test
    public void testEmptyInsert(){
        StringQueue.insert("world");
        assertEquals("world", StringQueue.findMax());
    }

    @Test
    public void testInsert(){
        StringQueue.insert("world");
        StringQueue.insert("hello");
        assertEquals("world", StringQueue.findMax());
    }

    @Test
    public void testSameInsert(){
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.insert("hi");
        StringQueue.insert("hello");
        assertEquals("world", StringQueue.findMax());
    }

    @Test
    public void testCorrectOrder(){
        StringQueue.insert("hi");
        StringQueue.insert("howdy");
        StringQueue.insert("heya");
        StringQueue.insert("hello");
        assertEquals("howdy", StringQueue.deleteMax());
        assertEquals("hi", StringQueue.deleteMax());
        assertEquals("heya", StringQueue.deleteMax());
        assertEquals("hello", StringQueue.deleteMax());
        assertEquals(true, StringQueue.isEmpty());
    }

    @Test
    public void testInsertFull(){
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.insert("pizza");
        StringQueue.insert("cookies");
        StringQueue.insert("donut");
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.insert("pizza");
        StringQueue.insert("cookies");
        StringQueue.insert("donut");
        StringQueue.insert("dog");

        //testing size
        assertEquals(20, StringQueue.getArraySize());
        assertEquals(11, StringQueue.size());

        //testing order
        assertEquals("world", StringQueue.deleteMax());
        assertEquals("world", StringQueue.deleteMax());
        assertEquals("pizza", StringQueue.deleteMax());
        assertEquals("pizza", StringQueue.deleteMax());
        assertEquals("hello", StringQueue.deleteMax());
        assertEquals("hello", StringQueue.deleteMax());
        assertEquals("donut", StringQueue.deleteMax());
        assertEquals("donut", StringQueue.deleteMax());
        assertEquals("dog", StringQueue.deleteMax());
        assertEquals("cookies", StringQueue.deleteMax());
        assertEquals("cookies", StringQueue.deleteMax());

    }

    // insertAll() tests -----------------------------------------------------------------------------------------------
    @Test
    public void testInsertAll(){
        listOfStrings.add("hi");
        listOfStrings.add("howdy");
        listOfStrings.add("heya");
        listOfStrings.add("hello");
        listOfStrings.add(null);
        StringQueue.insertAll(listOfStrings);

        //null check
        assertEquals(false, StringQueue.isEmpty());
        assertEquals(4, StringQueue.size());
        assertEquals("howdy", StringQueue.findMax());

        //testing the order
        assertEquals("howdy", StringQueue.deleteMax());
        assertEquals("hi", StringQueue.deleteMax());
        assertEquals("heya", StringQueue.deleteMax());
        assertEquals("hello", StringQueue.deleteMax());
        assertEquals(true, StringQueue.isEmpty());

    }

    @Test
    public void testInsertAllFull(){
        listOfStrings.add("hello");
        listOfStrings.add("world");
        listOfStrings.add("pizza");
        listOfStrings.add("hello");
        listOfStrings.add("cookies");
        listOfStrings.add("cookies");
        listOfStrings.add("donut");
        listOfStrings.add("dog");
        listOfStrings.add("world");
        listOfStrings.add("donut");
        listOfStrings.add("pizza");

        StringQueue.insertAll(listOfStrings);

        //testing size
        assertEquals(20, StringQueue.getArraySize());
        assertEquals(11, StringQueue.size());

        //testing order
        assertEquals("world", StringQueue.deleteMax());
        assertEquals("world", StringQueue.deleteMax());
        assertEquals("pizza", StringQueue.deleteMax());
        assertEquals("pizza", StringQueue.deleteMax());
        assertEquals("hello", StringQueue.deleteMax());
        assertEquals("hello", StringQueue.deleteMax());
        assertEquals("donut", StringQueue.deleteMax());
        assertEquals("donut", StringQueue.deleteMax());
        assertEquals("dog", StringQueue.deleteMax());
        assertEquals("cookies", StringQueue.deleteMax());
        assertEquals("cookies", StringQueue.deleteMax());

    }

    @Test
    public void testInsertAllEmpty(){
        StringQueue.insertAll(listOfStrings);
        assertEquals(true, StringQueue.isEmpty());
    }

    @Test
    public void testFilledInsertAll(){
        StringQueue.insert("cookie");
        StringQueue.insert("biscuit");
        StringQueue.insert("soup");

        listOfStrings.add("donut");
        listOfStrings.add("dog");
        listOfStrings.add("world");
        listOfStrings.add("donut");
        listOfStrings.add("pizza");
        StringQueue.insertAll(listOfStrings);

        assertEquals("world", StringQueue.findMax());
    }


    // contains() tests ------------------------------------------------------------------------------------------------
    @Test
    public void testContains(){
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.insert("pizza");
        StringQueue.insert("cookies");
        StringQueue.insert("donut");
        assertEquals(true ,StringQueue.contains("cookies"));
        assertEquals(false ,StringQueue.contains("cereal"));
    }
    @Test
    public void testContainsEmpty(){
        assertEquals(false, StringQueue.contains("cookies"));
    }

    @Test
    public void testContainsOneEntry(){
        StringQueue.insert("hello");
        assertEquals(false, StringQueue.contains("cookies"));
        assertEquals(true, StringQueue.contains("hello"));
    }

    // size() tests ----------------------------------------------------------------------------------------------------
    @Test
    public void testSize() {
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.insert("pizza");
        StringQueue.insert("cookies");
        StringQueue.insert("donut");
        assertEquals(5, StringQueue.size());
    }

    @Test
    public void testEmptySize() {
        assertEquals(0, StringQueue.size());
    }

    @Test
    public void testOneEntrySize(){
        StringQueue.insert("cookies");
        assertEquals(1, StringQueue.size());
    }

    // isEmpty() tests -------------------------------------------------------------------------------------------------
    @Test
    public void testIsEmpty(){
        assertEquals(true, StringQueue.isEmpty());
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.insert("hi");
        assertEquals(false, StringQueue.isEmpty());
    }

    @Test
    public void testVerySmallIsEmpty(){
        assertEquals(true, StringQueue.isEmpty());
        StringQueue.insert("world");
        assertEquals(false, StringQueue.isEmpty());
    }

    // clear() tests ---------------------------------------------------------------------------------------------------
    @Test public void testClear(){
        StringQueue.insert("world");
        StringQueue.insert("hello");
        StringQueue.clear();
        assertEquals(true, StringQueue.isEmpty());
    }





}
