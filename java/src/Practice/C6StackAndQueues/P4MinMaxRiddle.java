package Practice.C6StackAndQueues;

import java.util.*;

public class P4MinMaxRiddle {

    public static void main(String[] args) {
        int[] arr = {2,6,1,12};
        System.out.println(Arrays.toString(arr));
        int[] result = solve(arr);
        System.out.println("result: " + Arrays.toString(result));
    }

    static int[] solve(int[] arr) {
        int[] lefts = buildLefts(arr);
        int[] rigths = buildRights(arr);
        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rigths));

        SortedMap<Integer, Integer> numberLenght = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            numberLenght.put(arr[i], Math.max(numberLenght.getOrDefault(arr[i], 1) , rigths[i] + lefts[i] + 1));
        }
        System.out.println(numberLenght);

        Iterator<Integer> iter = numberLenght.keySet().iterator();
        int number = iter.next();
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            while (numberLenght.get(number) <= i){
                number = iter.next();
            }
            result[i] = number;
        }

        System.out.println(Arrays.toString(result));

        return result;
    }

    static int[] buildLefts(int[] arr) {
        int[] lefts = new int[arr.length];
        Stack<Integer> indicies = new Stack<>();

        for (int i = 0; i < lefts.length; i++) {
            while (!indicies.empty() && arr[i] <= arr[indicies.peek()]){
                indicies.pop();
            }

            lefts[i] = i - (indicies.empty() ? -1 : indicies.peek()) - 1;
            indicies.push(i);
        }

        return lefts;
    }

    static int[] buildRights(int[] arr){
        int[] rights = new int[arr.length];
        Stack<Integer> indicies = new Stack<>();

        for (int i = rights.length - 1; i >= 0; i--) {
            while (!indicies.empty() && arr[i] <= arr[indicies.peek()]){
                indicies.pop();
            }

            rights[i] = (indicies.empty() ? arr.length : indicies.peek()) - i - 1;
            indicies.push(i);
        }

        return rights;
    }
}
