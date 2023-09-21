package linked_lists.P5LinkedListDetectACycle;

// problem
// https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
// solution
// https://github.com/doocs/leetcode/blob/main/solution/0100-0199/0141.Linked%20List%20Cycle/README_EN.md
public class Solution1 {

    static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public boolean hasCycle (Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
