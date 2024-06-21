package linkedlist;

import java.util.PriorityQueue;

public class Problem4 {

    public ListNode mergeKLists(ListNode[] lists) {

        //Approch - Using Priority Queue
        //TC - O(NLogK) where N = total nodes present in merged list K = no. of lists
        //SC - O(K) storing head of all k lists

        ListNode dummyHead = new ListNode(0), temp = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> b.val - a.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            ListNode nextNode = smallest.next;
            smallest.next = null;
            temp.next = smallest;
            temp = temp.next;

            if(nextNode != null){
                pq.add(nextNode);
            }
        }
        return dummyHead.next;
    }
}
