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
    public ListNode partition(ListNode head, int x) {
        ListNode lessStart=null;
        ListNode lessEnd=null;
        ListNode greaterStart=null;
        ListNode greaterEnd=null;
        ListNode current=head;
        while(current!=null)
        {
            if(current.val<x)
            {
                if(lessStart==null)
                {
                    lessStart=current;
                    lessEnd=lessStart;
                }
                else
                {
                    lessEnd.next=current;
                    lessEnd=lessEnd.next;
                }
                
            }
            else
            {
                if(greaterStart==null)
                {
                    greaterStart=current;
                    greaterEnd=greaterStart;
                }
                else
                {
                    greaterEnd.next=current;
                    greaterEnd=current;
                }
            }
           current=current.next;
        
        }
        if(greaterEnd!=null)
            greaterEnd.next=null;
        if(lessStart==null)
            return greaterStart;
        lessEnd.next=greaterStart;
        return lessStart;
    }
}