package warmup_challange.SalesByMatch;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {

    public static void main(String[] args) {
        new SalesByMatch();
    }

    public SalesByMatch(){
        int n = 0;
        List<Integer> ar = new ArrayList<>();

        ar.add(10); ar.add(20); ar.add(20);
        ar.add(10); ar.add(10); ar.add(30);
        ar.add(50); ar.add(10); ar.add(20);

        Map<Integer, Integer> collection = new LinkedHashMap<>();
        for (int i = 0; i < ar.size(); i++) {
            Integer getValue = collection.getOrDefault(ar.get(i), 0);
            collection.put(ar.get(i), getValue + 1);
        }

        Integer counting = 0;
        for(Map.Entry<Integer, Integer> entry: collection.entrySet()){
            if(entry.getValue() % 2 == 0){
                counting = counting + (entry.getValue() / 2);
            }else{
                counting = counting + ((entry.getValue() - 1) / 2);
            }
        }

        System.out.println(counting);
    }
}
