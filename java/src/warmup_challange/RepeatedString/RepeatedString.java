package warmup_challange.RepeatedString;

public class RepeatedString {

    public static void main(String[] args) {
        new RepeatedString();
    }

    public RepeatedString(){
        // String s = "abcac";
        // long n = 10;

        // String s = "aba";
        // long n = 10;

        String s = "a";
        long n = 1000000000000L;


        char[] sChar = s.toCharArray();

        long length = sChar.length;

        long countingWord = 0;
        for (int i = 0; i < sChar.length; i++) {
            if(sChar[i] == 'a'){
                countingWord++;
            }
        }
        System.out.println(countingWord);

        long result = 0;
        if(n % length == 0){
            result = countingWord * (n / length);
        }else if(n % length != 0){
            long divide = n / length;
            long sisa = n % length;
            result = countingWord * divide;
            for (int i = 0; i < sisa; i++) {
                if(sChar[i] == 'a'){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
