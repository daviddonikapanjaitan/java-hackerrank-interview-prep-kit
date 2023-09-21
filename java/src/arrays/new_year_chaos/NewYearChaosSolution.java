package arrays.new_year_chaos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://github.com/hypersolid/competitive-programming/blob/master/hackerrank/algorithms/misc/New-Year-Chaos.java
// https://medium.com/@fahdmoh.1/hackerrank-new-year-chaos-problem-explained-with-solution-f55ad8cb7a4e
public class NewYearChaosSolution {

    public static void main(String[] args) {
        new NewYearChaosSolution();
    }

    public NewYearChaosSolution(){
        int minBribes = 0;
        List<Integer> q = new ArrayList<>();
        q.add(2);q.add(1);q.add(5);q.add(3);q.add(4);
        // q.add(2);q.add(5);q.add(1);q.add(3);q.add(4);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(4);q.add(7);q.add(8);q.add(6);
        // q.add(5);q.add(1);q.add(2);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        List<Integer> qSort = new ArrayList<>(q);
        Collections.sort(qSort);


        for (int i = 0; i < q.size(); i++) {
            if(q.get(i) - 2 > i + 1){
                System.out.println("Too chaotic");
                return;
            }
            for (int j = i - 1; j >= q.get(i) - 2 && j>= 0; j--) {
//                System.out.println(minBribes);
//                System.out.println(q);
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
//                System.out.println("q[j] = " + q.get(j));
//                System.out.println("q[i] = " + q.get(i));
                if (q.get(j) > q.get(i)) {
                    // System.out.println("true");
                    minBribes++;
                }

                // System.out.println();
            }
        }

        System.out.println(minBribes);
    }
}
