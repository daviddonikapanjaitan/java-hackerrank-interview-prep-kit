package Practice.C4Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2MarkAndToys {

    public static void main(String[] args) {
//        List<Integer> prices = new ArrayList<>(List.of(1, 2, 3, 4));
//        int k = 7;

        List<Integer> prices = new ArrayList<>(List.of(1,12,5,111,200,1000,10));
        int k = 50;

        Collections.sort(prices);
        int n = prices.size();
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if(prices.get(i) > k){
                break;
            }

            if(sum + prices.get(i) <= k){
                sum += prices.get(i);
                counter++;
            }
        }
        System.out.println(counter);
    }
}
