package Practice.C6StackAndQueues;

import java.util.*;

public class P6PoisonousPlants {

    public static void main(String[] args) {
        int[] pesticides = {6,5,8,4,7,10,9,5};

        System.out.println(poisonousPlants(pesticides));
    }

    static int poisonousPlants(int[] p){
        int[] days = new int[p.length];
        int maxDays = 0;
        int minDays = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[i - 1]) {
                days[i] = 1;
            }

            minDays = Math.min(minDays, p[i]);

            while (!stack.isEmpty() && p[stack.peek()] >= p[i]){
                increaseNumber(p, days, stack, minDays, i);
                stack.pop();
            }

            maxDays = Math.max(maxDays, days[i]);
            stack.push(i);
        }

        return maxDays;
    }

    private static void increaseNumber(int[] p, int[] days, Deque<Integer> stack, int minDays, int i){
        if(p[i] > minDays){
            days[i] = Math.max(days[i], days[stack.peek()] + 1);
        }
    }
}
