package sorting;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Akshay on 6/7/2016.
 */
public class InsertionSort {
    public static <T extends Comparable> T[] insertionSort(T[] arr){

        for (int i = 0, j; i < arr.length; i++) {
            j=i-1;
            T temp = arr[i];
            while (j>=0 && temp.compareTo(arr[j])<0){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1]=temp;
        }

        return arr;
    }

    public static <T> T[] insertionSort(T[] arr, Comparator<T> c){
        for (int i = 0; i < arr.length; i++) {
            T temp = arr[i];
            for (int j = i-1; j >= 0 && c.compare(temp,arr[j])<0 ; j--) {
                arr[j + 1] = arr[j];
                --j;
            }
        }
        return arr;
    }
}