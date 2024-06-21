package linkedlist;

public class Problem1 {

    public ListNode reverseList(ListNode head) {
//        head = iterative(head);
//        head = recursive(head);

        return head;
    }

    public ListNode iterative(ListNode head) {
//        Approach - Iterative
//        TC -  O(N)
//        SC - O(1) e

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode recursive(ListNode head) {
//        Approach - Recursive
//        TC -  O(N)
//        SC - O(N) recursive stack space

        if(head == null || head.next == null){
            return head;
        }

        ListNode nnode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nnode;
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int x){
        this.val = x;
        this.next = null;
    }

    ListNode(int x,ListNode next){
        this.val = x;
        this.next = next;
    }
}