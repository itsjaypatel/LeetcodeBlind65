package linkedlist;

public class Problem3 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode temp1 = l1, temp2 = l2, temp3 = dummy;
        while(temp1 != null && temp2 != null) {

            ListNode temp1Next = temp1.next;
            ListNode temp2Next = temp2.next;

            temp1.next = null;
            temp2.next = null;

            int val1 = temp1.val;
            int val2 = temp2.val;

            if(val1 < val2) {
                temp3.next = temp1;
                temp1 = temp1Next;
            }else{
                temp3.next = temp2;
                temp2 = temp2Next;
            }
            temp3 = temp3.next;
        }

        if(temp1 != null) {
            temp3.next = temp1;
        }
        if(temp2 != null) {
            temp3.next = temp2;
        }
        return dummy.next;
    }
}