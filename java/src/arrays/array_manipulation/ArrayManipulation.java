package arrays.array_manipulation;

import java.util.*;

public class ArrayManipulation {

    public static void main(String[] args) {
        new ArrayManipulation();
    }

    public ArrayManipulation(){
//        int n = 5;
//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(1, 2, 100));
//        queries.add(List.of(2, 5, 100));
//        queries.add(List.of(3, 4, 100));

        int n = 10;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 5, 3));
        queries.add(List.of(4, 8, 7));
        queries.add(List.of(6, 9, 1));

        long maxValue = 0;
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(0L);
        }

        for (List<Integer> query : queries) {
            for (int j = query.get(0); j <= query.get(1); j++) {

                result.set(j - 1, result.get(j - 1) == null ? (long) query.get(2) : result.get(j - 1) + query.get(2));

                if(result.get(j - 1) > maxValue){
                    maxValue = result.get(j - 1);
                }
            }
        }

        System.out.println(result);
        System.out.println(maxValue);
    }
}
