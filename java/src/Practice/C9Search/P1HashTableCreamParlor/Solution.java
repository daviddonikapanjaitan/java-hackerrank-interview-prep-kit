package Practice.C9Search.P1HashTableCreamParlor;

import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> cost = List.of(2, 1, 3, 5, 6);
        int money = 5;

//        List<Integer> cost = List.of(2, 2, 4, 3);
//        int money = 4;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            if(cost.get(i) < money) {


                if (!hashMap.containsKey(cost.get(i))) {
                    hashMap.put(cost.get(i), i);
                }
            }
        }
    }
}
