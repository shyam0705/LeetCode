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
    public ListNode mergeNodes(ListNode head) {
        ListNode prev=head;
        ListNode current=head.next;
        int sum=0;
        while(current!=null)
        {
            if(current.val==0)
            {
                ListNode tmp=new ListNode(sum);
                sum=0;
                prev.next=tmp;
                prev=tmp;
                
            }
            else
            {
                sum=sum+current.val;
            }
            current=current.next;
        }
        return head.next;
    }
}