package StringManipulation.common_child;

import java.util.Arrays;

// https://raw.githubusercontent.com/shivam04/hackerrank/master/common-child.java
// https://www.youtube.com/watch?v=ItRZRx8kvwY
public class CommonChildSolution {

    public static void main(String[] args) {
        new CommonChildSolution();
    }

    public CommonChildSolution(){
        String s1 = "ABCD";
        String s2 = "ABDC";

        int L[][] = new int[s1.length() + 1][s2.length() + 1];

        for(int i=0; i <= s1.length();i++){
            for(int j=0; j <= s2.length(); j++){
                if(i==0 || j==0){
                    L[i][j]=0;
                }else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    L[i][j] = L[i-1][j-1]+1;
                } else{
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
                }
            }
        }

        System.out.println(L[s1.length()][s2.length()]);
    }
}
