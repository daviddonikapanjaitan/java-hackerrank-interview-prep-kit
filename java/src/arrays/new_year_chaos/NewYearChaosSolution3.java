package arrays.new_year_chaos;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=C8p7KGkGcGA
public class NewYearChaosSolution3 {

    public static void main(String[] args) {
        new NewYearChaosSolution3();
    }

    public NewYearChaosSolution3(){
        List<Integer> q = new ArrayList<>();
        q.add(2);q.add(1);q.add(5);q.add(3);q.add(4);
        // q.add(2);q.add(5);q.add(1);q.add(3);q.add(4);

        int swaps = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if(q.get(i) != i + 1){
                if((i - 1) >= 0 && q.get(i - 1) == i + 1) {
                    int temp = q.get(i - 1);
                    q.set(i - 1, q.get(i));
                    q.set(i, temp);
                    swaps++;
                } else if((i - 2) >= 0 && q.get(i - 2) == i + 1){
                    q.set(i -2, q.get(i - 1));
                    q.set(i - 1, q.get(i));
                    q.set(i, q.get(i - 2));
                    swaps += 2;
                }else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }
}
