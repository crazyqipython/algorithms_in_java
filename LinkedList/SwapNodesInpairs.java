package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null && cur.next != null){
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}