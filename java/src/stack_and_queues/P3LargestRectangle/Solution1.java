package stack_and_queues.P3LargestRectangle;

import java.util.Stack;

// problem
// https://www.hackerrank.com/challenges/largest-rectangle/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
// solution
// https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
public class Solution1 {

    static int getMaxArea(int[] hist, int n) {
        Stack<Integer> s = new Stack<>();

        int max_area = 0;
        int tp;
        int area_with_top;

        int i = 0;
        while(i < n){
            if(s.empty() || hist[s.peek()] <= hist[i]){
                s.push(i++);
            } else {
                tp = s.peek();
                s.pop();

                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                if(max_area < area_with_top){
                    max_area = area_with_top;
                }
            }
        }

        while (!s.empty()) {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if(max_area < area_with_top){
                max_area = area_with_top;
            }
        }

        return max_area;
    }

    public static void main(String[] args) {
        // int[] hist = {6,2,5,4,5,1,6};
        int[] hist = {1,2,3,4,5};

        System.out.println(getMaxArea(hist, hist.length));
    }
}
