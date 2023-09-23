package stack_and_queues.P6PoisonousPlants;

import java.util.ArrayDeque;
import java.util.Deque;

// problem
// https://www.hackerrank.com/challenges/poisonous-plants/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
// solution
// https://github.com/mariazevedo88/hackerrank-challenges/blob/master/src/main/java/io/github/mariazevedo88/hc/prepkit/stacks/PoisonousPlants.java
public class Solution1 {

    public static void main(String[] args) {
        int[] pesticides1 = {6,5,8,4,7,10,9};

        System.out.println(poisonousPlants(pesticides1));
    }

    static int poisonousPlants(int[] p) {
        int[] days = new int[p.length];
        int minDays = p[0];
        int maxDays = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        for (int i = 1; i < p.length; i++){
            if (p[i] > p[i - 1]) {
                days[i] = 1;
            }

            minDays = minDays < p[i] ? minDays : p[i];

            while (!stack.isEmpty() && p[stack.peek()] >= p[i]){
                increaseNumberOfDays(p, days, minDays, stack, i);
                stack.pop();
            }

            maxDays = maxDays > days[i] ? maxDays : days[i];
            stack.push(i);
        }

        return maxDays;
    }

    private static void increaseNumberOfDays(int[] p, int[] days, int minDays, Deque<Integer> stack, int i) {
        if (p[i] > minDays) {
            days[i] = days[i] > days[stack.peek()] + 1 ?
                    days[i] : days[stack.peek()] + 1;
        }
    }
}
