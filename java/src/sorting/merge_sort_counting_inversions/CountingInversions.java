package sorting.merge_sort_counting_inversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingInversions {

    public static void main(String[] args) {
        new CountingInversions();
    }

    public CountingInversions(){
        List<Integer> arr = new ArrayList<>();
//        arr.add(2); arr.add(1); arr.add(3);
//        arr.add(1); arr.add(2);

        arr.add(2); arr.add(4); arr.add(1);
//        arr.add(1); arr.add(1); arr.add(1);
//        arr.add(2); arr.add(2);

        System.out.println(Arrays.toString(arr.toArray()));
        long counting = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if(j > 0 && arr.get(j - 1) > arr.get(j)){
                    int temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                    counting++;
                }
            }
            // System.out.println(Arrays.toString(arr.toArray()));
        }

        System.out.println(Arrays.toString(arr.toArray()));
        System.out.println(counting);
    }
}
