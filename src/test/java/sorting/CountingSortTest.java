package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/7/2016.
 */
public class CountingSortTest {
    @Test
    public void countingSort() throws Exception {
        int[] arr = new int[]{1,2,23,234,45,43,21,31,12};
        arr = CountingSort.countingSort(arr,234);
        assertArrayEquals(arr,new int[]{1,2,12,21,23,31,43,45,234});
    }

}