package stack_and_queues.P1BalancedBrackets;

import java.util.ArrayDeque;
import java.util.Deque;

// problem
// https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
// solution
// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class Solution1 {

    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if(x == '(' || x == '[' || x == '{'){
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. so stack
            // cannot be empty at this point.
            if(stack.isEmpty()) {
                return false;
            }
            char check;
            switch(x){
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '['){
                        return false;
                    }
                    break;
                case '}':
                    check = stack.pop();
                    if(check == '(' || check == '['){
                        return false;
                    }
                    break;
                case ']':
                    check = stack.pop();
                    if(check == '(' || check == '{'){
                        return false;
                    }
                    break;
            }
        }

        // Check empty stack
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String expr = "[]({})()[]{}{}[]({}{})[]{([])()[()][{()({})[{}{[[()]{}[]][]}(({{[]{()()()}{}[]()}[]}){{}{}})]}]}";

        if(areBracketsBalanced(expr)){
            System.out.printf("Balanced");
        }else{
            System.out.printf("Not Balanced");
        }
    }
}
