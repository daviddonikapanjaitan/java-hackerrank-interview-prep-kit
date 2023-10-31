package Practice.C4Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P5MergeSortCountingInversions {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2); arr.add(4); arr.add(1);arr.add(5);arr.add(6);arr.add(5);

        long result = mergeSort(arr);
        System.out.println(result);
    }

    public static long mergeSort(List<Integer> arr){
        int size = arr.size();
        if(size == 1){
            return 0;
        }

        int mid = size / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, size));
        arr.clear();

        return mergeSort(left) + mergeSort(right) + merge(left, right, arr);
    }

    public static long merge(List<Integer> left, List<Integer> right, List<Integer> dst){
        int leftIndex = 0;
        int rightIndex = 0;
        int leftSize = left.size();
        int rightSize = right.size();
        long inversion = 0;

        while(leftIndex < leftSize && rightIndex < rightSize){
            int leftItem = left.get(leftIndex);
            int rightItem = right.get(rightIndex);

            if(leftItem > rightItem){
                dst.add(rightItem);
                rightIndex++;
                inversion += leftSize - leftIndex;
            } else {
                dst.add(leftItem);
                leftIndex++;
            }
        }

        while(leftIndex < leftSize){
            dst.add(left.get(leftIndex++));
        }

        while(rightIndex < rightSize){
            dst.add(right.get(rightIndex++));
        }

        return inversion;
    }
}
