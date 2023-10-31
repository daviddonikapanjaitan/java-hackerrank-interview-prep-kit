package others.C3Queue.P1Queue;

class QueueArray {

    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size){
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = - 1;
        System.out.println("The Queue is successfully created with size of: " + size);
    }

    // isFull
    public boolean isFull(){
        if(topOfQueue == arr.length - 1){
            return true;
        } else {
            return false;
        }
    }

    // isEmpty
    public boolean isEmpty(){
        if(beginningOfQueue == -1 || (beginningOfQueue == arr.length)){
            return true;
        } else {
            return false;
        }
    }

    // Enqueue
    public void endQueue(int value) {
        if(isFull()){
            System.out.println("The Queue is Full!");
        } else if(isEmpty()){
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
    }

    // deQueue
    public int doQueue() {
        if(isEmpty()){
            System.out.println("The Queue is empty");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue){
                beginningOfQueue = topOfQueue = - 1;
            }
            return result;
        }
    }

    // Peek
    public int peek(){
        if(!isEmpty()){
            return arr[beginningOfQueue];
        } else {
            System.out.println("The Queue is empty");
            return -1;
        }
    }

    public void deleteQueue(){
        arr = null;
        System.out.println("The Queue is successfully deleted!");
    }
}

public class Main {

    public static void main(String[] args) {
        QueueArray newQueue = new QueueArray(3);
        newQueue.endQueue(1);
        newQueue.endQueue(2);
        newQueue.endQueue(3);
        System.out.println(newQueue.peek());
        newQueue.doQueue();
        System.out.println(newQueue.peek());
        newQueue.deleteQueue();
    }
}
