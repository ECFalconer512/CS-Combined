package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class SimplePriorityQueue<E> implements PriorityQueue<E> {

    private E[] array = (E[]) new Object[10];
    private Comparator<? super E> cmp;

    public SimplePriorityQueue() {

    }

    public SimplePriorityQueue(Comparator<? super E> cmp) {
        this.cmp = cmp;
    }

    @Override
    public E findMax() throws NoSuchElementException {
        if (array[array.length - 1] == null) {
            throw new NoSuchElementException();
        }
        return array[array.length - 1];
    }

    public int binarySearch(E item){
        int low = 0;
        int high = array.length-1;
        int mid;
        int indexInsert;

        while(low!=high){
            mid = (low + high)/2;
            int result;

            if (array[mid] == null) {
                low = mid + 1;
                continue;
            }
            if(item instanceof Comparable){
                Comparable<E> thing = (Comparable<E>) item;
                result = thing.compareTo(array[mid]);
            }
            else{
                result = cmp.compare(item, array[mid]);
            }
            if(result<0){
                high = mid;
            }
            else if(result == 0){
                return mid;
            }
            else {
                if (low == mid) {
                    if(item instanceof Comparable){
                        Comparable<E> thing = (Comparable<E>) item;
                        result = thing.compareTo(array[mid + 1]);
                    }
                    else{
                        result = cmp.compare(item, array[mid + 1]);
                    }
                    if(result > 0) {
                        return mid + 1;
                    }
                    return mid;
                }
                low = mid + 1;
            }
        }

        mid = (low + high)/2;
        int result;
        if (array[mid]==null){
            return mid;
        }
        if(item instanceof Comparable){
            Comparable<E> thing = (Comparable<E>) item;
            result = thing.compareTo(array[mid]);
        }
        else{
            result = cmp.compare(item, array[mid]);
        }
        if(result<0){
            return mid - 1;
        }
        else if(result == 0){
            return mid;
        }
        else
            return mid;
    }

    @Override
    public E deleteMax() throws NoSuchElementException {
        E object = findMax();
        array[array.length - 1] = null;
        for(int i=array.length-1; i>0; i--){
            array[i] = array[i-1];
        }
        array[0] = null;
        return object;
    }

    @Override
    public void insert(E item) {
        if (item == null)
            return;

        //space check
        if (array[0] != null) {
            //increase array size
            E[] newArray = (E[]) new Object[array.length * 2];
            for (int i = array.length - 1; i >= 0; i--) {
                newArray[i + array.length] = array[i];
            }
            array = newArray;
        }

        //binary search
        int indexInsert = binarySearch(item);
        for(int i=1; i<=indexInsert; i++){
            if(array[i]!=null){
                array[i-1]=array[i];
            }
        }
        array[indexInsert] = item;
        
    }

    @Override
    public void insertAll(Collection coll) {
        // TODO Auto-generated method stub
        Iterator listOfObj = coll.iterator();

        while(listOfObj.hasNext()){
            insert((E)listOfObj.next());
        }
    }

    @Override
    public boolean contains(E item) {
        // TODO Auto-generated method stub
        int index = binarySearch(item);
        int result;
        if (array[index] == null)
            return false;

        if(item instanceof Comparable){
            Comparable<E> thing = (Comparable<E>) item;
            result = thing.compareTo(array[index]);
        }
        else{
            result = cmp.compare(item, array[index]);
        }

        if (result == 0) {
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        for (E entry: array){
            if(entry != null)
                return false;
        }
        return true;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        for (int i=0; i<array.length; i++){
            array[i] = null;
        }
        
    }

    public int getArraySize(){
        return array.length;
    }
    
}
