package stack_and_queues.P4MinMaxRiddle;

import java.util.*;

// problem
// https://www.hackerrank.com/challenges/min-max-riddle/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
// solution
// https://github.com/charles-wangkai/hackerrank/blob/master/min-max-riddle/Solution.java
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] solution = solve(arr);
        for (int i = 0; i < solution.length; i++) {
            if(i != 0){
                System.out.print(" ");
            }
            System.out.print(solution[i]);
        }

        sc.close();
    }

    static int[] solve(int[] arr) {
        int[] lefts = buildLefts(arr);
        int[] rights = buildRights(arr);
        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rights));

        SortedMap<Integer, Integer> numberToLength = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(lefts[i] + rights[i] + 1 + ", " + arr[i] + ", " + numberToLength.getOrDefault(arr[i], 1));
            numberToLength.put(arr[i], Math.max(numberToLength.getOrDefault(arr[i], 1), lefts[i] + rights[i] + 1));
        }
        System.out.println(numberToLength);

        Iterator<Integer> iter = numberToLength.keySet().iterator();
        int number = iter.next();
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            while(numberToLength.get(number) <= i){
                number = iter.next();
            }

            result[i] = number;
        }

        return result;
    }

    static int[] buildLefts(int[] arr) {
        int[] lefts = new int[arr.length];

        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!indices.empty() && arr[i] <= arr[indices.peek()]){
                indices.pop();
            }

            lefts[i] = i - (indices.empty() ? -1 : indices.peek()) - 1;
            indices.push(i);
        }

        return lefts;
    }

    static int[] buildRights(int[] arr) {
        int[] rights = new int[arr.length];

        Stack<Integer> indices = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!indices.empty() && arr[i] <= arr[indices.peek()]){
                indices.pop();
            }

            rights[i] = (indices.empty() ? arr.length : indices.peek()) - i - 1;
            indices.push(i);
        }

        return rights;
    }
}
