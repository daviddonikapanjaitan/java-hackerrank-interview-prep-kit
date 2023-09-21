package arrays.array_manipulation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation2 {

    public static void main(String[] args) {
        new ArrayManipulation2();
    }

    public ArrayManipulation2(){
        // int n = 5;
        // List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(1, 2, 100));
//        queries.add(List.of(2, 5, 100));
//        queries.add(List.of(3, 4, 100));
//        int n = 10;
//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(1, 5, 3));
//        queries.add(List.of(4, 8, 7));
//        queries.add(List.of(6, 9, 1));

//        int n = 10;
//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(2, 6, 8));
//        queries.add(List.of(3, 5, 7));
//        queries.add(List.of(1, 8, 1));
//        queries.add(List.of(5, 9, 15));

        int n = 10000000;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 2, 100));
        queries.add(List.of(2, 5, 100));
        queries.add(List.of(3, 4, 100));

//        int n = 4000;
//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(2250, 2540, 180674));
//        queries.add(List.of(2459, 3892, 434122));
//        queries.add(List.of(2321, 3289, 363503));
//        queries.add(List.of(1975, 2754, 374161));

        long[][] countLong = new long[queries.size()][n];
        long maxValue = 0L;

        for (int i = 0; i < queries.size(); i++) {
            long[] resultArray = new long[n];
            for (int j = queries.get(i).get(0); j <= queries.get(i).get(1); j++) {
                resultArray[j - 1] = queries.get(i).get(2);
            }
            countLong[i] = resultArray;
            System.out.println(Arrays.toString(resultArray));
        }

        for (int i = 0; i < n; i++) {
            long totalCount = 0L;
            for (int j = 0; j < queries.size(); j++) {
                totalCount += countLong[j][i];
            }
            if(totalCount > maxValue){
                maxValue = totalCount;
            }
        }


        System.out.println(maxValue);
    }
}
