package arrays.minimump_swap_2;

import java.util.Arrays;

// https://github.com/sknsht/HackerRank/blob/master/Interview%20Preparation%20Kit/Arrays/Minimum%20Swaps%202/Solution.java
public class MinimumSwamp2 {

    public static void main(String[] args) {
        new MinimumSwamp2();
    }

    public MinimumSwamp2(){
        // int[] arr = {7, 1, 3, 2, 4, 5, 6};
        // int[] arr = {4, 3, 1, 2};
        // int[] arr = {2,3,4,1,5};
        int[] arr = {1, 3, 5, 2, 4, 6, 7};

        int[] array = arr;
        int n = array.length - 1;
        int minSwaps = 0;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < n; i++) {
            if(i < array[i] - 1){
                // swap
                swap(array, i, Math.min(n, array[i] - 1));
                System.out.println(Arrays.toString(array));
                minSwaps++;
                i--;
            }
        }

        System.out.println(minSwaps);
    }

    void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
