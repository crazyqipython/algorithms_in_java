import java.util.PriorityQueue;

import LinkedList.ListNode;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node: lists){
            if (node != null) pq.add(node);
        }
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (cur.next != null) pq.add(cur.next);
        }
        return dummy.next;
    }
}

// public class MergeKSortedLists(){

// }'
public class MergeKSortedLists {
  public static void main(String[] args) {
    ListNode list = new ListNode(0);
    System.out.println("Hello World");
  }
}