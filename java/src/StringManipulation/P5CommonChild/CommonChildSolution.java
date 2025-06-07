package StringManipulation.P5CommonChild;

// https://raw.githubusercontent.com/shivam04/hackerrank/master/common-child.java
// https://www.youtube.com/watch?v=ItRZRx8kvwY
public class CommonChildSolution {

    public static int commonChild(String str1, String str2){
        int L[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
                if(i==0 || j==0)
                    L[i][j]=0;
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    L[i][j] = L[i-1][j-1]+1;
                }
                else{
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
                }
            }
        }
        return L[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";
        int result = commonChild(s1, s2);

        System.out.println(result);
    }
}
