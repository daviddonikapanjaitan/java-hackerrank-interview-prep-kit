package others.C3Queue.P3QueueLinkedList;

class Node {

    public int value;
    public Node next;
}

class LinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert Method SinglyLinkedLIst
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0){
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while(index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // SinglyLinkedList Traversal
    public void traverseSinglyLinkedList(){
        if(head == null) {
            System.out.println("SLL does not exists!");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if(i != size - 1){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // Search for a node
    boolean searchNode(int nodeValue){
        if(head != null){
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if(tempNode.value == nodeValue) {
                    System.out.print("Found the node at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found! ");
        return false;
    }

    // Deleting a node from SinglyLinkedList
    public void deletionOfNode(int location) {
        if(head == null){
            System.out.println("The SLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        } else if (location >= size){
            Node tempNode = head;
            for(int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if(tempNode == head){
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // Delete Entire SinglyLinkedList
    public void deleteSLL(){
        head = null;
        tail = null;
        System.out.println("The SLL deleted successfully");

    }
}

class QueueLinkedList {

    LinkedList list;

    public QueueLinkedList(){
        list = new LinkedList();
        System.out.println("The Queue is successfully created");
    }

    public boolean isEmpty(){
        if(list.head == null){
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value){
        list.insertInLinkedList(value, list.size);
        System.out.println("Successfully inserted " + value + " in the queue");
    }

    public int doQueue(){
        int value = -1;
        if(isEmpty()){
            System.out.println("The Queue is Empty");
        } else {
            value = list.head.value;
            list.deletionOfNode(0);
        }
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return -1;
        } else {
            return list.head.value;
        }
    }

    public void deleteQueue(){
        list.head = null;
        list.tail = null;
        System.out.println("The Queue is successfully deleted");
    }
}

public class Main {

    public static void main(String[] args) {
        QueueLinkedList newQLL = new QueueLinkedList();
        newQLL.enQueue(10);
        newQLL.enQueue(20);
        newQLL.enQueue(30);
        System.out.println(newQLL.peek());
        System.out.println(newQLL.doQueue());
        System.out.println(newQLL.peek());
    }
}
