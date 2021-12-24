/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode start=new ListNode();
        ListNode prev=start;
        start.next=head;
        ListNode current=head;
        while(current.next!=null)
        {
            if(current.next.val>current.val)
            {
                current=current.next;
            }
            else
            {
                while(prev.next!=null && prev.next.val<current.next.val)
                {
                    prev=prev.next;
                }
                ListNode tmp=prev.next;
                prev.next=current.next;
                current.next=current.next.next;
                prev.next.next=tmp;
                prev=start;
            }
        }
        return start.next;
        
    }
}