package linked_lists.P1InsertANodeAtASpecificPosition;

// Java program for insertion in a single linked
// list at a specified position
// problem
// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
// solution
// https://www.geeksforgeeks.org/insert-a-node-at-a-specific-position-in-a-linked-list/
public class Solution1 {

    // A linked list node
    static class Node {
        public int data;
        public Node nextNode;

        // inserting the required data
        public Node(int data) {
            this.data = data;
        }
    }

    // function to create and return a node
    static Node GetNode(int data){
        return new Node(data);
    }

    // function to insert a Node at required position
    static Node insertPos(Node headNode, int position, int data) {
        Node head = headNode;
        position = position + 1;
        if(position < 1) {
            System.out.printf("Invalid position");
        }

        // If position is 1 then new node is
        // set infront of head node
        // head node is changing
        if(position == 1) {
            Node newNode = new Node(data);
            newNode.nextNode = headNode;
            head = newNode;
        } else {
            while(position-- != 0) {
                if(position == 1){
                    // adding Node at required position
                    Node newNode = GetNode(data);

                    // Making the new Node to point to
                    // the old Node at the same position
                    newNode.nextNode = headNode.nextNode;

                    // Replacing current with new Node
                    // to the old Node to point to the new Node
                    headNode.nextNode = newNode;
                    break;
                }
                headNode = headNode.nextNode;
            }

            if(position != 1){
                System.out.print("Position out of range");
            }
        }

        return head;
    }

    static void printList(Node node) {
        while(node != null) {
            System.out.print(node.data);
            node = node.nextNode;
            if(node != null){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = GetNode(3);
        head.nextNode = GetNode(5);
        head.nextNode.nextNode = GetNode(8);
        head.nextNode.nextNode.nextNode = GetNode(10);

        System.out.print("Linked list before insertion: ");
        printList(head);

        int data = 12, pos = 3;
        head = insertPos(head, pos, data);
        System.out.print("Linked list after " + " insertion of 12 at position 3: ");
        printList(head);

        // front of the linked list
        data = 1;
        pos = 1;
        head = insertPos(head, pos, data);
        System.out.print("Linked list after" + " insertion of 1 at position 1: ");
        printList(head);

        // insertion at end of the LinkedList
        data = 15;
        pos = 7;
        head = insertPos(head, pos, data);
        System.out.print("Linked list after " + " insertion of 15 at position 7: ");
        printList(head);
    }
}
