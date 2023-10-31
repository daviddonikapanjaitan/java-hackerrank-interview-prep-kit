package Practice.C2Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3NewYearChaos {

    public static void main(String[] args) {
        new P3NewYearChaos();
    }

    public P3NewYearChaos(){
        List<Integer> q = new ArrayList<>();
        q.add(2); q.add(1); q.add(5); q.add(3); q.add(4);

        int swaps = 0;
        boolean isChaotic = false;

        for (int i = q.size() - 1; i >= 0; i--) {
            if(i + 1 != q.get(i)){
                if(i - 2 >= 0 && i + 1 == q.get(i - 2)){
                    int temp1 = q.get(i);
                    int temp2 = q.get(i - 1);
                    q.set(i -1, temp1);
                    q.set(i - 2, temp2);
                    swaps = swaps + 2;
                } else if(i - 1 >= 0 && i + 1 == q.get(i - 1)){
                    int temp1 = q.get(i);
                    int temp2 = q.get(i - 1);
                    q.set(i - 1, temp1);
                    q.set(i, temp2);
                    swaps++;
                } else {
                    isChaotic = true;
                }
            }
        }

        if(isChaotic){
            System.out.println("Too chaotic");
        }else{
            System.out.println(swaps);
        }
    }
}
