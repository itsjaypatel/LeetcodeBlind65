package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    public boolean hasCycle(ListNode head) {

        /*
            Approch - Using Set
            TC -O(N)
            SC -O(1)
            Set<ListNode> set = new HashSet<>();
            ListNode cur = head;
            while (cur != null) {
                if(!set.add(cur)) {
                    return true;
                }
            }
            return false;
         */

        //Approch - Using Fast and slow pointer
        // TC - O(N)
        // SC - O(1)

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}