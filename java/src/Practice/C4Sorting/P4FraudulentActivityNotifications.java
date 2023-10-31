package Practice.C4Sorting;

import java.util.ArrayList;
import java.util.List;

public class P4FraudulentActivityNotifications {

    public static void main(String[] args) {
        List<Integer> expenditure = new ArrayList<>();
        int d = 4;
        expenditure.add(2); expenditure.add(3); expenditure.add(4);
        expenditure.add(2); expenditure.add(3); expenditure.add(6);
        expenditure.add(8); expenditure.add(4); expenditure.add(5);

        int[] expenditureArray = new int[expenditure.size()];

        for (int i = 0; i < expenditure.size(); i++) {
            expenditureArray[i] = expenditure.get(i);
        }

        int[] countData = new int[201];
        for (int i = 0; i < d; i++) {
            countData[expenditureArray[i]]++;
        }

        int answer = 0;
        for (int i = d; i < expenditureArray.length; i++) {
            int today = expenditureArray[i];
            double median = getMedian(d, countData);
            System.out.println(median);
            if(today >= (2 * median)){
                answer++;
            }

            countData[today]++;
            countData[expenditureArray[i-d]]--;
        }
    }

    static double getMedian(int d, int[] countData){
        if(d % 2 == 0){
            int tbh = d / 2;
            int cnt = 0;
            for (int i = 0; i < countData.length; i++) {
                cnt += countData[i];
                if(cnt > tbh){
                    return i;
                } else if(tbh == cnt){
                    for (int j = i + 1; j < countData.length; j++) {
                        if(countData[j] > 0){
                            return (double) (i + j) /(double) 2;
                        }
                    }
                }
            }
        } else {
            int tbh = d / 2 + 1;
            int cnt = 0;
            for (int i = 0; i < countData.length; i++) {
                cnt += countData[i];
                if(cnt >= tbh){
                    return i;
                }
            }
        }

        return -1;
    }
}
