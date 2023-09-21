package sorting.bubble_sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        new BubbleSort();
    }

    public BubbleSort(){
        List<Integer> a = new ArrayList<>();
        // a.add(6); a.add(4); a.add(1);
        a.add(5); a.add(3); a.add(1); a.add(2); a.add(4);

        int counting = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    int temp  = a.get(j + 1);
                    int temp2 = a.get(j);
                    a.set(j, temp);
                    a.set(j + 1, temp2);
                    counting++;
                }
            }
        }
        System.out.println("Array is sorted in " + counting + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));
    }
}
