package search.P3Pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// problem
// https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
// solution
// https://www.hackerrank.com/challenges/pairs/forum?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
public class Solution1 {

    public static int pairs(int k, List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        arr.sort(null);

        for(int value: arr) {
            int frequency = map.getOrDefault(value, 0);
            map.put(value, frequency + 1);
        }

        int pairs = 0;

        for(int item: map.keySet()){
            int positive = item + k;
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
