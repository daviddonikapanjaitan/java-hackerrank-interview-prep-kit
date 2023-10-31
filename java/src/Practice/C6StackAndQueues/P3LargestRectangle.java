package Practice.C6StackAndQueues;

import java.util.Stack;

public class P3LargestRectangle {

    static int getMaxArea(int[] hist, int n) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int maxAreaTop = 0;
        int tp;
        int i = 0;

        while (i < n) {
            if(stack.empty() || hist[stack.peek()] <= hist[i]){
                stack.push(i++);
            } else {
                tp = stack.peek();
                stack.pop();

                maxAreaTop = hist[tp] * (stack.empty() ? i : (i - stack.peek() - 1));
                if(maxArea < maxAreaTop){
                    maxArea = maxAreaTop;
                }
            }
        }

        while (!stack.empty()){
            tp = stack.peek();
            stack.pop();

            maxAreaTop = hist[tp] * (stack.empty() ? i : (i - stack.peek() - 1));
            if(maxArea < maxAreaTop){
                maxArea = maxAreaTop;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] hist = {4,4,5,3,5,4};
        System.out.println(getMaxArea(hist, hist.length));
    }
}
