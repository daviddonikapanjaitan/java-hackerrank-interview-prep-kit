package Practice.C9Search.P3Pairs;

import java.util.*;

public class Solution {

    public static int pairs(int k, List<Integer> arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        arr.sort(null);

        for(Integer value: arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int pairs = 0;
        for(Integer key: map.keySet()){
            int positive = key + k;
            pairs += map.getOrDefault(positive, 0);
        }

        return pairs;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1); arr.add(5); arr.add(3);
        arr.add(4); arr.add(2);
        int result = pairs(2, arr);
        System.out.println(result);
    }
}
