package arrays.NewYearChaos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewYearChaosSolution4 {

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // q.add(2);q.add(5);q.add(1);q.add(3);q.add(4);

        int bribes = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0, j = 1; i < q.size(); i++, j++){
            if(map.containsKey(q.get(i))) continue;
            if(map.containsKey(j)){
                i--;
                continue;
            }
            if(q.get(i) - j != 0){
                int max = 2;
                boolean tooFar = true;
                for(int k = 1, add = 0; k <= max; k++){
                    if(map.containsKey(j + k)){
                        max++;
                        continue;
                    }
                    add++;
                    if(q.get(i) - (j + k) == 0){
                        bribes += add;
                        tooFar = false;
                        break;
                    }
                }
                if(tooFar){
                    System.out.println("Too chaotic");
                    return;
                }
                j--;
            }
            map.put(q.get(i), q.get(i));
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2); input.add(1); input.add(5); input.add(3); input.add(4);
        minimumBribes(input);
    }
}
