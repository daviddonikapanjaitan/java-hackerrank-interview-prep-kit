package GreedyAlgorithm.P5ReverseShuffleMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    static char[] position;
    static int[] count;
    static int n;
    static int m;
    static HashMap<Integer, int[]> right;
    static HashMap<Integer, List<Integer>> myMap;
    static int min;

    public static String reverseShuffleMerge(String s) {
        n = s.length();
        m = n / 2;
        String ss = new StringBuilder(s).reverse().toString();
        count = new int[26];
        right = new HashMap<>();
        myMap = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int[] temp = Arrays.copyOf(count, 26);
            right.put(i, temp);
            count[ss.charAt(i) - 'a']++;
            int value = ss.charAt(n - 1 - i) - 'a';
            List<Integer> tempList = myMap.getOrDefault(value, new ArrayList<>());
            tempList.add(n - 1 - i);
            myMap.put(value, tempList);
        }

        for (int i = 0; i < 26; i++) count[i] /= 2;
        min = -1;
        position = new char[m];

        for (int i = 0; i < m; i++) {
            labelA:
                for (int j = 0; j < 26; j++) {
                    if (count[j] == 0) continue;
                    List<Integer> tempL = myMap.get(j);
                    for (int k = 0; k < tempL.size(); k++) {
                        if (tempL.get(k) <= min) continue;
                        count[j]--;
                        if (isValid(tempL.get(k))) {
                            min = tempL.get(k);
                            position[i] = (char)('a' + j);
                            break labelA;
                        }else{
                            count[j]++;
                            break;
                        }
                    }
                }
        }
        return new String(position);
        // Write your code here
    }

    static boolean isValid(int p) {
        int[] temp = right.get(p);
        for (int i = 0; i < 26; i++) {
            if (temp[i] < count[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // String input = "aeiouuoiea";
        String input = "abcdefgabcdefg";
        String result = reverseShuffleMerge(input);
        System.out.println(result);
    }
}
