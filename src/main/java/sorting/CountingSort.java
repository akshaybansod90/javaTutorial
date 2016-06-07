package sorting;

/**
 * Created by Akshay on 6/7/2016.
 */
public class CountingSort {
    public static int[] countingSort(int[] arr,int maxValue){
        int[] count = new int[maxValue+1];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        return output;
    }
}
