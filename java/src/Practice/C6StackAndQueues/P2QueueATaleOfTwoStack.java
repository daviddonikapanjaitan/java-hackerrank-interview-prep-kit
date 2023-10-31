package Practice.C6StackAndQueues;

import stack_and_queues.P2QueuesATaleOfTwoStack.Solution1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2QueueATaleOfTwoStack {

    public static class MyQueue<T>{
        Queue<T> queue = new LinkedList<>();

        public void enqueue(T value){
            queue.add(value);
        }

        public T peek(){
            return queue.peek();
        }

        public T dequeue(){
            return queue.remove();
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
