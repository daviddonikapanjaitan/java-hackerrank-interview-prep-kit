package Practice.C9Search.P5MinimumTimeRequired;

import javax.swing.plaf.IconUIResource;

public class Solution {

    static long solve(int[] machines, int goal) {
        long result = -1;
        long upper = Long.MAX_VALUE;
        long lower = 0;
        while (lower <= upper) {
            long middle = (lower + upper) / 2;
            if(computeItemNum(machines, middle) >= goal){
                result = middle;

                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return result;
    }

    static int computeItemNum(int[] machines, long days) {
        long itemNumber = 0;
        for(int machine: machines) {
            itemNumber += (days / machine);

            if(itemNumber >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }

        return (int) itemNumber;
    }

    public static void main(String[] args) {
        int[] input = {2,3,2};
        long result = solve(input, 10);
        System.out.println(result);
    }
}
