package Practice.Others.C1LinkedLists.P1SinglyLinkedList;

class Node {
    public int value;
    public Node next;
}

class SinglyLinkedLists {

    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedLists(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return node;
    }

    public void insertInLinkedList(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){
            createSinglyLinkedLists(nodeValue);
        } else if(location == 0){
            node.next = head;
            head = node;
        } else if(location >= size){
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

    public void traverseSinglyLinkedList(){
        if(head == null){
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

    boolean searchNode(int nodeValue){
        if(head != null){
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if(tempNode.value == nodeValue){
                    System.out.print("Found the node at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }

        System.out.print("Node not found");

        return false;
    }

    public void deletionOfNode(int location){
        if(head == null){
            System.out.println("The SLL does not exist");
            return;
        } else if(location == 0){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        } else if(location >= size){
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
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
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteSLL(){
        head = null;
        tail = null;
        System.out.println("The SLL deleted successfully");
    }
}

public class Solution {

    public static void main(String[] args) {
        SinglyLinkedLists sLL = new SinglyLinkedLists();
        sLL.createSinglyLinkedLists(5);
        System.out.println(sLL.head.value);
        sLL.insertInLinkedList(7, 1);
        sLL.insertInLinkedList(8, 2);
        sLL.insertInLinkedList(9, 3);
        sLL.insertInLinkedList(10, 4);
        sLL.insertInLinkedList(11, 5);
        sLL.traverseSinglyLinkedList();
        sLL.searchNode(5);
        sLL.deletionOfNode(3);
        sLL.traverseSinglyLinkedList();
        sLL.deleteSLL();
        sLL.traverseSinglyLinkedList();
    }
}
