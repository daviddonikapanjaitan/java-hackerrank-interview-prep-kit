package Practice.C9Search.P6MaximumSubarraySum;

import java.util.List;
import java.util.TreeSet;

// Kadane’s Algorithm
public class Solution {

    public static long maximumSum(List<Long> a, long m) {
        TreeSet<Long> set = new TreeSet<>();
        long mod = 0, max = 0;
        for (long num: a) {
            mod = (mod + (num % m)) % m;
            max = Math.max(max, mod);
            Long next = set.ceiling(mod + 1);
            if(next != null) {
                max = Math.max(max, m - (next - mod));
            }
            set.add(mod);
        }

        return max;
    }

    public static void main(String[] args) {
        List<Long> max = List.of(3L, 3L, 9L, 9L, 5L, 1L);
        long result = maximumSum(max, 7);
        System.out.println(result);
    }
}
