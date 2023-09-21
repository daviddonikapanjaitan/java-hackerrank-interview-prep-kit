package sorting.merge_sort_counting_inversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Result Failed.
// https://www.geeksforgeeks.org/java-program-for-count-inversions-in-an-array-set-1-using-merge-sort/
public class CountingInversionsSolution {

    public static void main(String[] args) {
        new CountingInversionsSolution();
    }

    public CountingInversionsSolution(){
        List<Integer> array = new ArrayList<>();
        array.add(2); array.add(1); array.add(3);
        array.add(1); array.add(2);

//        array.add(2); array.add(4); array.add(1);

//        array.add(1); array.add(1); array.add(1);
//        array.add(2); array.add(2);

        int[] arr = new int[array.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array.get(i);
        }

        int l = 0 ;
        int r = arr.length - 1;

        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    public static int mergeSortAndCount(int[] arr, int l, int r){
        int count = 0;

        if(l < r){
            int m = (l + r) / 2;

            count += mergeSortAndCount(arr, l, m);

            count += mergeSortAndCount(arr, m + 1, r);

            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public static int mergeAndCount(
            int[] arr, int l, int m, int r
    ){
        // left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while(i < left.length){
            arr[k++] = left[i++];
        }

        while(j < right.length){
            arr[k++] = right[j++];
        }

        return swaps;
    }
}
