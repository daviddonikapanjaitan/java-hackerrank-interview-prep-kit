package Practice.C2Arrays;

import java.util.Arrays;

public class P4MinimumSwaps {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4,6,7};

        int[] array = arr;
        int minSwaps = 0;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < arr.length; i++) {
            if(i  + 1 != (arr[i])) {
                int location = arr[i] - 1;
                int temp = arr[i];
                int temp2 = arr[location];
                arr[location] = temp;
                arr[i] = temp2;
                minSwaps++;
                i--;
            }
        }
        System.out.println(minSwaps);

    }
}
