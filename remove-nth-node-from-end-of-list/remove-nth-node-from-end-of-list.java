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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current1=head;
        ListNode current2=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        current2=dummy;
        while(current1!=null)
        {
            if(n>0)
            {
                current1=current1.next;
                n--;
            }
            else
            {
                current1=current1.next;
                current2=current2.next;
            }
        }
       
        current2.next=current2.next.next;
        return dummy.next;
        
        
        
    }
}