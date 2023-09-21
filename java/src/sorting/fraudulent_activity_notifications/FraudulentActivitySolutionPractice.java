package sorting.fraudulent_activity_notifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://taesunny.github.io/problem-solving/hackerrank-fraudulent-activity-notifications/
public class FraudulentActivitySolutionPractice {

    public static void main(String[] args) {
        new FraudulentActivitySolutionPractice();
    }

    public FraudulentActivitySolutionPractice(){
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
            double preAvg = getAverage(countData, d);

            if ((double) today >= preAvg * (double) 2) {
                System.out.println("today: " +today);
                System.out.println("prevAvg: " + preAvg);
                answer++;
            }

            countData[today]++;
            countData[expenditureArray[i - d]]--;
        }

        System.out.println(answer);
    }

    static double getAverage(int[] countData, int d){
        System.out.println(Arrays.toString(countData));
        if(d % 2 == 0){
            int targetNTh1 = d / 2;
            System.out.println("targetNth1: " + targetNTh1);

            int cnt = 0;
            for (int i = 0; i < countData.length; i++) {
                cnt += countData[i];
                System.out.println("cnt: " + cnt);
                System.out.println("i: " + i);

                if(cnt > targetNTh1){
                    return (double) i;
                } else if(cnt == targetNTh1){
                    for (int j = i + 1; j < countData.length; j++) {
                        System.out.println("j: " + j);
                        if(countData[j] > 0){
                            return (double) (i + j) / (double) 2;
                        }
                    }
                }
            }
        } else {
            int targetNTh1 = d / 2 + 1;

            int cnt = 0;
            for (int i = 0; i < countData.length; i++) {
                cnt += countData[i];

                if(cnt >= targetNTh1){
                    return (double) i;
                }
            }
        }

        return -1;
    }
}
