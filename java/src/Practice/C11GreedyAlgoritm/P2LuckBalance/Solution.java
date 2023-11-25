package Practice.C11GreedyAlgoritm.P2LuckBalance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        int winCount = 0, luckCount = 0;

        k = contests.stream().filter(c -> c.get(1) == 1).toList().size() - k;

        contests.sort(Comparator.comparing(c -> c.get(0)));

        for(List<Integer> contest: contests){
            if ((winCount < k) && (contest.get(1) == 1)) {
                winCount++;
                luckCount -= contest.get(0);
            } else {
                luckCount += contest.get(0);
            }
        }

        return luckCount;
    }

    public static void main(String[] args) {
        int k = 1;
        List<List<Integer>> contest =
                Arrays.asList(Arrays.asList(5, 1), Arrays.asList(1, 1),
                        Arrays.asList(4, 0));
        int result = luckBalance(k, contest);
        System.out.println(result);

//        int k = 3;
//        List<List<Integer>> contest =
//                Arrays.asList(Arrays.asList(5, 1), Arrays.asList(2, 1),
//                        Arrays.asList(1, 1), Arrays.asList(8, 1),
//                        Arrays.asList(10, 0), Arrays.asList(5, 0));
//        int result = luckBalance(k, contest);
//        System.out.println(result);
    }
}
