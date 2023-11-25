package Practice.C9Search.P4TripleSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static long triplets(List<Integer> a, List<Integer> b, List<Integer> c) {
        a = a.stream().distinct().sorted().collect(Collectors.toList());
        b = b.stream().distinct().sorted().collect(Collectors.toList());
        c = c.stream().distinct().sorted().collect(Collectors.toList());

        long answer = 0;
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while (bi < b.size()) {
            while (ai < a.size() && a.get(ai) <= b.get(bi)) {
                ai++;
            }

            while (ci < c.size() && b.get(bi) >= c.get(ci)) {
                ci++;
            }

            answer += ((long) ai * (long) ci);
            System.out.println("Asnwer: " + answer);

            bi++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//        List<Integer> c = new ArrayList<>();
//        a.add(1); a.add(4); a.add(5);
//        b.add(2); b.add(3); b.add(3);
//        c.add(1); c.add(2); c.add(3);
//        long result = triplets(a, b, c);
//        System.out.println(result);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        a.add(1); a.add(3); a.add(5); a.add(7);
        b.add(5); b.add(7); b.add(9);
        c.add(7); c.add(9); c.add(11); c.add(13);
        long result = triplets(a, b, c);
        System.out.println(result);
    }
}
