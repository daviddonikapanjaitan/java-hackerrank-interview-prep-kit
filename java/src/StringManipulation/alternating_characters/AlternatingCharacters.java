package StringManipulation.alternating_characters;

public class AlternatingCharacters {

    public static void main(String[] args) {
        new AlternatingCharacters();
    }

    public AlternatingCharacters(){
        // String s = "AABAAB";
//        String s = "AAAA";
        // String s = "BBBBB";
        String s = "AAABBB";

        char[] sChar = s.toCharArray();
        char flag = sChar[0];
        int  count  = 0;
        for (int i = 1; i < sChar.length; i++) {
            if(flag == sChar[i]){
                flag = sChar[i];
                sChar[i] = ' ';
                count++;
            }else {
                flag = sChar[i];
            }
        }

        System.out.println(sChar);
        System.out.println(count);
    }
}
