package linked_lists.P4FindMergePointOfTwoList;

// problem
// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
// solution
// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class Solution1 {

    static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    // function to get the intersection point of two linked
    // list head1 and head2
    public Node getIntersectionNode(Node head1, Node head2) {
        while(head2 != null) {
            Node temp = head1;
            while(temp != null) {
                // if both nodes are same
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Solution1 list = new Solution1();

        Node head1, head2;

        /*
                Create two linked lists

                1st 3->6->9->15->30
                2nd 10->15->30

                15 is the intersection point
        */

        head1 = new Node(10);
        head2 = new Node(3);

        Node newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30);
        head1.next.next = newNode;

        head1.next.next.next = null;

        Node intersectionPoint =
                list.getIntersectionNode(head1, head2);

        if(intersectionPoint == null){
            System.out.print(" No Intersection point \n ");
        } else {
            System.out.print("Intersection point: " + intersectionPoint.data);
        }
    }
}
