package Search.P1HashTablesIceCreamParlor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://gist.github.com/oliverwreath/60255a2566cfd1ef5a1e750eaed22c7b
public class HashTablesSolution {

    public static void main(String[] args) {
        new HashTablesSolution();
    }

    public HashTablesSolution() {
        List<Integer> cost = new ArrayList<>();
        cost.add(2); cost.add(2); cost.add(4);
        cost.add(3);
        int money = 4;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            if(cost.get(i) < money){
                if(hashMap.containsKey(money - cost.get(i))){
                    int index = hashMap.get(money - cost.get(i));
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }

                if(!hashMap.containsKey(cost.get(i))){
                    hashMap.put(cost.get(i), i);
                }
            }
        }
    }
}
