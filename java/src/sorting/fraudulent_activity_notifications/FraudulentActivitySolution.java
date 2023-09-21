package sorting.fraudulent_activity_notifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://taesunny.github.io/problem-solving/hackerrank-fraudulent-activity-notifications/
public class FraudulentActivitySolution {

    public static void main(String[] args) {
        new FraudulentActivitySolution();
    }

    public FraudulentActivitySolution(){
        List<Integer> expenditure = new ArrayList<>();
        int d = 5;
        expenditure.add(2); expenditure.add(3); expenditure.add(4);
        expenditure.add(2); expenditure.add(3); expenditure.add(6);
        expenditure.add(8); expenditure.add(4); expenditure.add(5);

        int[] exprenditureArray = new int[expenditure.size()];

        for (int i = 0; i < expenditure.size(); i++) {
            exprenditureArray[i] = expenditure.get(i);
        }
        System.out.println(Arrays.toString(exprenditureArray));

        int[] countData = new int[201];

        for (int i = 0; i < d; i++) {
            countData[exprenditureArray[i]]++;
        }

        int answer = 0;

        for (int i = d; i < exprenditureArray.length; i++) {
            int today = exprenditureArray[i];
            double preAvg = getAverage(countData, d);

            if ((double) today >= preAvg * (double) 2) {
                answer++;
            }

            countData[today]++;
            countData[exprenditureArray[i - d]]--;
        }

        System.out.println(answer);
    }

    static double getAverage(int[] countData, int d) {
        if (d % 2 == 0) {
            int targetNTh1 = d / 2;

            int cnt = 0;
            for (int i = 0; i < countData.length; i++) {
                cnt += countData[i];

                if (cnt > targetNTh1) {
                    return (double) i;
                } else if (cnt == targetNTh1) {
                    for (int j = i + 1; j < countData.length; j++) {
                        if (countData[j] > 0) {
                            return (double) (i + j) / (double) 2;
                        }
                    }
                }
            }
        } else {
            int targetNTh = d / 2 + 1;

            int cnt = 0;
            for (int i = 0; i < countData.length; i++) {
                cnt += countData[i];
                if (cnt >= targetNTh) {
                    return (double) i;
                }
            }
        }

        return -1;
    }
}
