package linkedlist;

import java.util.PriorityQueue;
import java.util.Stack;

public class Problem5 {

    record Pair<X,Y>(X x, Y y) {}
    public ListNode removeNthFromEnd(ListNode head, int n) {

        /*
        Approch - Recursion (two pass)
        TC - (N)
        SC - O(N) recursive stack space

        Pair<ListNode,Integer> headPair = removeNthFromEndUtil(head,n);
        return headPair.x();

         */

        /*

        Approch - Using stack (two pass)
        TC - (N)
        SC - O(N) stack size

        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }

        int popped = 0;
        ListNode lastPopped = null;
        while(!stack.isEmpty()) {
            ListNode poppedNode = stack.pop();
            popped++;

            poppedNode.next = lastPopped;
            if(popped != n) {
                lastPopped = poppedNode;
            }
        }
        return lastPopped;
        */


        //Approch - Two Pointer(single pass)
        //TC - O(N)
        //SC - O(1)

        ListNode p1 = null, p2 = head, previousOfP1 = null;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        p1 = head;
        while (p2 != null) {
            previousOfP1 = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (previousOfP1 == null) {
            return head.next; // when to delete head node (nth node form reverse)
        }
        previousOfP1.next = p1.next;
        return head;
    }
    public Pair<ListNode, Integer> removeNthFromEndUtil(ListNode head, int n) {
        if(head == null)
            return new Pair<>(null, 0);

        Pair<ListNode, Integer> nextPair = removeNthFromEndUtil(head.next,n);

        if(nextPair.y() == (n - 1)){
            return new Pair<>(nextPair.x(), nextPair.y() + 1);
        }else{
            head.next = nextPair.x();
            return new Pair<>(head, nextPair.y() + 1);
        }
    }
}
