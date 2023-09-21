package linked_lists.P3ReverseADoublyLinkedList;

// problem
// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
// solution
// https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
public class Solution1 {

    static Node head;

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    // UTILITY FUNCTIONS
    // Function to insert a node at the beginning of the
    // doubly linked list
    void push (int newData) {
        // allocate node
        Node newNode = new Node(newData);

        // since we are adding at the beginning
        // prev is always null
        newNode.prev = null;

        // link the old list of the new node
        newNode.next = head;

        // change prev of head node to new node
        if(head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    // Function to reverse a Doubly Linked List
    void reverse () {
        Node temp = null;
        Node current = head;

        // Swap next and prev for all nodes of doubly linked list
        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Before changing head, check for the cases like
        // empty list and list with only one node
        if(temp != null) {
            head = temp.prev;
        }
    }

    void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Solution1 list = new Solution1();

        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);

        System.out.println("Original linked list");
        list.printList(head);

        // Function call
        list.reverse();

        System.out.println("");
        System.out.println("The reversed Linked List is");
        list.printList(head);
    }
}
