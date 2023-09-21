package dictionaries_and_hashmaps.count_triplets;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// link tutorial
// https://github.com/Java-aid/Hackerrank-Solutions/blob/master/HackerRankDashboard/Interview-Preparation-Kit/src/main/java/com/javaaid/dictionaries/CountTriplets.java
public class SolutionGithub {

    public static void main(String[] args) {
        new SolutionGithub();
    }

    public SolutionGithub() {
//        List<Long> arr = List.of(1L, 2L, 2L, 4L);
//        long r =2;
        List<Long> arr = List.of(1L, 3L, 9L, 9L, 27L, 81L);
        long r = 3;

        Map<Long, Long> leftMap = new LinkedHashMap<>();
        Map<Long, Long> rightMap = new LinkedHashMap<>();

        for (long item: arr){
            rightMap.put(item, rightMap.getOrDefault(item, 0L) + 1);
        }

        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            long c1 = 0, c3 = 0;

            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);

            if (leftMap.containsKey(midTerm / r) && midTerm % r == 0) {
                c1 = leftMap.get(midTerm / r);
            }

            if (rightMap.containsKey(midTerm * r))
                c3 = rightMap.get(midTerm * r);

            count += c1 * c3;

            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
//            System.out.println();
//            System.out.println(midTerm);
//            System.out.println(c1);
//            System.out.println(c3);
//            System.out.println(rightMap);
//            System.out.println(leftMap);
        }

        System.out.println(count);
    }
}
