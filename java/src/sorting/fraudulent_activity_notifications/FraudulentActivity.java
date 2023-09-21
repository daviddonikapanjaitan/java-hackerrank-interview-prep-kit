package sorting.fraudulent_activity_notifications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FraudulentActivity {

    public static void main(String[] args) {
        new FraudulentActivity();
    }

    public FraudulentActivity(){
        List<Integer> expenditure = new ArrayList<>();
//        int d = 3;
//        expenditure.add(10); expenditure.add(20); expenditure.add(30);
//        expenditure.add(40); expenditure.add(50);
        int d = 5;
        expenditure.add(2); expenditure.add(3); expenditure.add(4);
        expenditure.add(2); expenditure.add(3); expenditure.add(6);
        expenditure.add(8); expenditure.add(4); expenditure.add(5);

        Integer median;
        Integer counting = 0;
        for (int i = 0; i < expenditure.size(); i++) {
            int end = 0;
            if(i + 1 > d) {
                end = i - 1;
            }

            if(end > 0 ){
                int start = end - (d - 1);
                List<Integer> arrayList = new ArrayList<>();
                for (int j = start; j <= end; j++) {
                    arrayList.add(expenditure.get(j));
                }

                median =  getMedian(arrayList);
                if(expenditure.get(i) >= (median * 2)){
                    counting = counting + 1;
                }
            }
        }

        System.out.println(counting);
    }

    public Integer getMedian(List<Integer> dataMedian){
        Collections.sort(dataMedian);
        int size = dataMedian.size();
        if(size % 2 == 0){
            size = (size / 2);
            return (dataMedian.get(size) + dataMedian.get(size + 1)) / 2;
        } else {
            size = (size / 2);
            return dataMedian.get(size);
        }
    }
}
