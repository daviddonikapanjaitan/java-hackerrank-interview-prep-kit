package Miscellaneous.P3FriendCircleQueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
public class Solution {

    public static void main(String[] args) {
        // int[][] input = new int[][]{{1, 2}, {3, 4}, {2, 3}}
//        int[][] input = new int[][]{{1, 2}, {1, 3}};
        int[][] input = new int[][]{{1000000000, 23}, {11, 3778},
                {7, 47}, {11, 1000000000}};

        int[] result = maxCircle(input);
        System.out.println(Arrays.toString(result));
    }

    static int[] maxCircle(int[][] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> personToId = new HashMap<>();
        ArrayList<Integer> relation = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < queries.length; i++) {
            int p1 = getParent(personToId, relation, count, queries[i][0]);
            int p2 = getParent(personToId, relation, count, queries[i][1]);

            if(p1 != p2) {
                if(count.get(p1) < count.get(p2)) {
                    relation.set(p1, p2);
                    count.set(p2, count.get(p1) + count.get(p2));

                    maxSoFar = Integer.max(maxSoFar, count.get(p2));
                } else {
                    relation.set(p2, p1);
                    count.set(p1, count.get(p1) + count.get(p2));
                    maxSoFar = Integer.max(maxSoFar, count.get(p1));
                }
            }

            res[i] = maxSoFar;
        }

        return res;
    }

    private static int getParent(Map<Integer, Integer> personToId, ArrayList<Integer> relation,
                                 ArrayList<Integer> count, int f) {
        if(!personToId.containsKey(f)){
            personToId.put(f, relation.size());
            relation.add(relation.size());
            count.add(1);
        }

        int id = personToId.get(f);

        while (relation.get(id) != id) {
            id = relation.get(id);
        }

        return id;
    }
}
