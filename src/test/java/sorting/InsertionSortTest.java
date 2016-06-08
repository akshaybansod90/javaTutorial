package sorting;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/7/2016.
 */
public class InsertionSortTest {
    @Test
    public void insertionSort() throws Exception {

        Integer[] arr = new Integer[]{1,2,23,234,45,43,21,31,12};
        arr = InsertionSort.insertionSort(arr);
        assertArrayEquals(arr,new Integer[]{1,2,12,21,23,31,43,45,234});
    }

    @Test
    public void insertionSortComparator() throws Exception {

        Integer[] arr = new Integer[]{1,2,23,234,45,43,21,31,12};
        arr = InsertionSort.insertionSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertArrayEquals(arr,new Integer[]{1,2,12,21,23,31,43,45,234});
    }

}