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
    public ListNode reverse(ListNode head,int right,int index)
    {
        if(head.next==null)
        {
            return head;
        }
        ListNode current=head.next;
        ListNode prev=head;
        while(index!=right)
        {
            ListNode tmp=current.next;
            current.next=prev;
            prev=current;
            current=tmp;
            index++;
        }
        // System.out.println(current.val+" "+prev.val);
        head.next=current;
        return prev;
        
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tmp_head=new ListNode();
        tmp_head.next=head;
        ListNode current=head;
        ListNode prev=tmp_head;
        int index=1;
        while(index!=left)
        {
            prev=current;
           current=current.next; 
            index++;
        }
        // System.out.println(prev.val+" "+current.val);
        prev.next=reverse(current,right,index);
        return tmp_head.next;
    }
}