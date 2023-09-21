package arrays.array_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://github.com/alexprut/HackerRank/blob/master/Data%20Structures/Arrays/Array%20Manipulation/Solution.java#L16
public class ArrayManipulationSolution {

    public static void main(String[] args) {
        new ArrayManipulationSolution();
    }

    public ArrayManipulationSolution(){
        int n = 5;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 2, 100));
        queries.add(List.of(2, 5, 100));
        queries.add(List.of(3, 4, 100));

         long[] computation = new long[n];
         for (int i = 0; i < queries.size(); i++) {
            int a = queries.get(i).get(0) - 1;
            int b = queries.get(i).get(1) - 1;
            int k = queries.get(i).get(2);

            computation[a] += k;
            if(b + 1 < n){
                computation[b + 1] -= k;
            }

             System.out.println(Arrays.toString(computation));
        }

         long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
