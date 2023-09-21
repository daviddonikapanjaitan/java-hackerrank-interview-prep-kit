package stack_and_queues.P1BalancedBrackets;

import java.util.Stack;

// solution mail_adnanhabib
// https://www.hackerrank.com/challenges/balanced-brackets/forum
public class Solution2 {

    public static boolean isOpening(char c) {
        return c == '(' || c == '{' || c =='[';
    }

    public static boolean isMatching(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');
    }

    public static String isBalanced(String str) {
        // str = "{[()]}"
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(isOpening(cur)) {
                s.push(cur);
            } else {
                if(s.isEmpty()){
                    return "NO";
                } else if (!isMatching(s.peek(), cur)){
                    return "NO";
                } else {
                    s.pop();
                }
            }
        }

        if(s.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String input = "()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}";
        System.out.println(isBalanced(input));;
    }
}
