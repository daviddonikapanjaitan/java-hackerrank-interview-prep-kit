package recursion_and_backtracking.P1RecursionFibonacciNumbers;

// problem
// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
// solution
// self solving
public class Solution1 {

    public static int fibonacci (int start, int end) {
        if(end == 0){
            return 0;
        } else if(end == 1){
            return  1;
        }
        return count(0, 0, start, end - 1);
    }

    public static int count(int prev, int current, int start, int end) {
        if(start == 0){
            prev = 0;
            current = 0;
        }
        if(start == 1){
            prev = 0;
            current = 1;
        }
        if(start == end){
            return prev + current;
        }

        return count(current, prev + current, start + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0, 10));
    }
}
