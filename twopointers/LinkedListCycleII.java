package TwoPointers;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head, entry=head, slow=head;
        
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow){
                while(entry != slow){
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        
        return null;
    }
}
