package StringManipulation.P5CommonChild;

// https://raw.githubusercontent.com/shivam04/hackerrank/master/common-child.java
// https://www.youtube.com/watch?v=ItRZRx8kvwY
public class CommonChildSolution {

    public static int commonChild(String s1, String s2){
        int[][] array = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0){
                    array[i][j] = 0;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    array[i][j] = array[i-1][j-1] + 1;
                }else{
                    array[i][j] = Math.max(array[i][j-1], array[j-1][i]);
                }
            }
        }

        return array[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ABDC";
        int result = commonChild(s1, s2);

        System.out.println(result);
    }
}
