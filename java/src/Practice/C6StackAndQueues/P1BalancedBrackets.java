package Practice.C6StackAndQueues;

import java.util.Objects;
import java.util.Stack;

public class P1BalancedBrackets {

    public static boolean isOpening(char input){
        return input == '{' || input == '[' || input == '(';
    }

    public static boolean isValid(char stackInput, char index){
        return (Objects.equals(stackInput, '{') && Objects.equals(index, '}')) ||
                (Objects.equals(stackInput, '[') && Objects.equals(index, ']')) ||
                (Objects.equals(stackInput, '(') && Objects.equals(index, ')'));
    }

    public static String isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if(isOpening(input.charAt(i))){
                stack.push(input.charAt(i));
            } else {
                if(stack.empty()){
                    return "NO";
                } else if (isValid(stack.peek(), input.charAt(i))) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        if(stack.empty()){
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println(isBalanced(input));;
    }
}
