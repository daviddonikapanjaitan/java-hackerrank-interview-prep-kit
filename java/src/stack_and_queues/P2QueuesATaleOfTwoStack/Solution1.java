package stack_and_queues.P2QueuesATaleOfTwoStack;

import java.util.Scanner;
import java.util.Stack;

// problem
// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
// solution
// https://github.com/benjaminpatrickevans/HackerRank/blob/master/Cracking%20the%20Coding%20Interview/Data%20Structures/Queues-%20A%20Tale%20of%20Two%20Stacks.java
public class Solution1 {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        public T peek(){
            transferStack();
            return stackOldestOnTop.peek();
        }

        public T dequeue(){
            transferStack();
            return stackOldestOnTop.pop();
        }

        private void transferStack(){
            if(!stackOldestOnTop.isEmpty()){
                return;
            }
            while(!stackNewestOnTop.isEmpty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if(operation == 1){
                queue.enqueue(scan.nextInt());
            } else if (operation == 2){
                queue.dequeue();
            } else if(operation == 3) {
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
