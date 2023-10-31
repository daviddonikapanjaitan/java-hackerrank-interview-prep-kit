package Search.P1HashTablesIceCreamParlor;

import java.util.ArrayList;
import java.util.List;

public class HashTables {

    public static void main(String[] args) {
        new HashTables();
    }

    public HashTables(){
        List<Integer> cost = new ArrayList<>();
//        cost.add(2); cost.add(1); cost.add(3);
//        cost.add(5); cost.add(6);
//        int money = 5;

//        cost.add(1); cost.add(4); cost.add(5);
//        cost.add(3); cost.add(2);
//        int money = 4;

        cost.add(2); cost.add(2); cost.add(4);
        cost.add(3);
        int money = 4;

        for (int i = 0; i < cost.size(); i++) {
            for (int j = i + 1; j < cost.size(); j++) {
                if(money > cost.get(i)  && money > cost.get(j)){
                    if(cost.get(i) +  cost.get(j) == money){
                        System.out.print(i + 1 + " ");
                        System.out.println(j + 1);
                    }
                }
            }
        }
    }
}
