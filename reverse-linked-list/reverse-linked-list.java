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
    ListNode root;
    public ListNode recur(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            root=head;
            return head;
        }
        else
        {
            ListNode next=recur(head.next);
            next.next=head;
            return head;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return null;
        }
        root=null;
        ListNode tmp=recur(head);
        tmp.next=null;
        return root;
    }
}