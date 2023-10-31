package Practice.C4Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1SortingBubbleSort {

    public static void main(String[] args) {
        // int[] a = {6,4,1};
        List<Integer> a = new ArrayList<>();
        a.add(3); a.add(2); a.add(1);
        int n = a.size();

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(a.get(j) > a.get(j + 1)){
                    int temp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temp);
                    swaps++;
                }
            }
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));
    }
}
