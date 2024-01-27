package Miscellaneous.P4MaximumXor;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/maximum-xor/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
public class Solution {

    static class Node {
        Node zero;
        Node one;

        void add(int num, int bit) {
            if(bit == -1) return;

            if(((num >> bit) & 1) == 0){
                if(zero == null) zero = new Node();
                zero.add(num, bit - 1);
            } else {
                if(one == null) one = new Node();
                one.add(num, bit - 1);
            }
        }

        int get(int num, int bit) {
            if(bit == -1) return 0;
            if(((num >> bit) & 1 ) == 0 && one != null || zero == null){
                return (1 << bit) ^ one.get(num, bit - 1);
            } else {
                return (0 << bit) ^ zero.get(num, bit - 1);
            }
        }
    }

    static int[] maxXor(int[] arr, int[] queries) {
        int[] answer = new int[queries.length];
        Node root = new Node();
        for(int i: arr){
            root.add(i, 30);
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = queries[i] ^ root.get(queries[i], 30);
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] inputArray = {0, 1, 2};
//        int[] inputQueries = {3, 7, 2};

        int[] inputArray = {5, 1, 7, 4, 3};
        int[] inputQueries = {2, 0};

        int[] result = maxXor(inputArray, inputQueries);
        System.out.println(Arrays.toString(result));
    }
}
