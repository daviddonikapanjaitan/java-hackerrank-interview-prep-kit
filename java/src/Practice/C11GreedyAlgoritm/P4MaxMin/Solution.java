package Practice.C11GreedyAlgoritm.P4MaxMin;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int maxMin(int k, List<Integer> arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size() - k; i++) {
            int b = arr.get(i);
            int a = arr.get(i + k - 1);
            min = Math.min(min, a - b);
        }

        return min;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,10,20,30,40,100,200);
        int result = maxMin(4, input);
        System.out.println(result);
    }
}
