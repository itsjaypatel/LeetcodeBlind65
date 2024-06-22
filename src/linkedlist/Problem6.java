package linkedlist;

public class Problem6 {

    //Link - https://leetcode.com/problems/reorder-list/description/

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new Problem6().reorderList(head);
    }

    public void reorderList(ListNode head) {

        //Approch - Two Pointer
        //TC - O(N)
        //SC - O(1)

        if (head == null || head.next == null || head.next.next == null) return;
        ListNode middle = findMiddle(head);

        ListNode head2 = middle.next;
        middle.next = null;

        head2 = reverse(head2);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head != null || head2 != null){
            ListNode headNext = head == null ? null : head.next;
            ListNode head2Next = head2 == null ? null : head2.next;

            if(head != null){
                head.next = null;
                temp.next = head;
                temp = temp.next;
            }
            if(head2 != null){
                head2.next = null;
                temp.next = head2;
                temp = temp.next;
            }

            head = headNext;
            head2 = head2Next;
        }
        head = dummy.next;
    }
    public ListNode findMiddle(ListNode head) {
        ListNode dummyHead = new ListNode(0); // two handle case for even number of nodes in list
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null,curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
