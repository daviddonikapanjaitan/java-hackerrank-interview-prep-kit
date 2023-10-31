package others.C2Stack.P2StackLinkedList;

class Node{
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

class StackLinkedList {

    LinkedList linkedList;

    public StackLinkedList(){
        linkedList = new LinkedList();
    }

    public void push(int value){
        linkedList.insertInLinkedList(value, 0);
        System.out.println("Inserted " + value + " in stack");
    }

    // isEmpty
    public boolean isEmpty(){
        if(linkedList.head == null) {
            return true;
        } else {
            return false;
        }
    }

    // Pop method
    public int pop(){
        int result = -1;
        if(isEmpty()){
            System.out.println("The Stack is empty!");
        } else {
            result = linkedList.head.value;
            linkedList.deletionOfNode(0);
        }
        return result;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("The stack is empty!");
            return -1;
        } else {
            return linkedList.head.value;
        }
    }

    public void deleteStack(){
        linkedList.head = null;
        System.out.println("The stack is deleted");
    }
}

public class Main {

    public static void main(String[] args) {
        StackLinkedList newStack = new StackLinkedList();
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        System.out.println(newStack.peek());
        System.out.println(newStack.pop());
        System.out.println(newStack.peek());

        newStack.deleteStack();
    }
}
