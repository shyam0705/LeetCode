/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        if(head==null || head.next==null)
        {
            return null;
        }
        do{
            slow=slow.next;
            fast=fast.next.next;
        }
        while(slow!=fast &&  fast!=null && fast.next!=null );
        if(slow==fast)
        {
            slow=head;
            while(slow!=fast)
            {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
}