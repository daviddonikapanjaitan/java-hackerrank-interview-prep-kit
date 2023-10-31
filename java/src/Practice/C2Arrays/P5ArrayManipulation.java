package Practice.C2Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P5ArrayManipulation {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 2, 100));
        queries.add(List.of(2, 5, 100));
        queries.add(List.of(3, 4, 100));

        long[] computation = new long[n];
        for (int i = 0; i < queries.size(); i++) {
            int start = queries.get(i).get(0) - 1;
            int end = queries.get(i).get(1) - 1;
            int value = queries.get(i).get(2);

            computation[start] = computation[start] + value;
            if(end + 1 < n){
                computation[end + 1] = computation[end + 1] + (value * - 1);
            }
            System.out.println(Arrays.toString(computation));
        }

        long sum = 0;
        long max = 0;
        for (int i = 0; i < computation.length; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
