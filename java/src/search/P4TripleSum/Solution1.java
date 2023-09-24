package search.P4TripleSum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// problem
// https://www.hackerrank.com/challenges/triple-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
// solution from discussion
public class Solution1 {

    public static long triplets(List<Integer> a, List<Integer> b, List<Integer> c) {
        a = a.stream().distinct().sorted().collect(Collectors.toList());
        b = b.stream().distinct().sorted().collect(Collectors.toList());
        c = c.stream().distinct().sorted().collect(Collectors.toList());;

        long answer = 0;
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while(bi < b.size()){

            while(ai < a.size() && a.get(ai) <= b.get(bi)){
                ai++;
            }
            while(ci < c.size() && c.get(ci) <= b.get(bi)){
                ci++;
            }

            answer += ((long) ai) * ((long) ci);
            System.out.println("answer = " + answer);
            bi++;
        }

        return answer;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        a.add(3); a.add(5); a.add(7);
        b.add(3); b.add(6);
        c.add(4); c.add(6); c.add(9);
        long result = triplets(a, b, c);
        System.out.println(result);
    }
}
