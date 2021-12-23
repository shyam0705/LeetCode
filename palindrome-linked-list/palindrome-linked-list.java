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
    public boolean isPalindrome(ListNode head) {
        ListNode prev=null;
        ListNode slow=head;
        if(head.next==null)
        {
            return true;
        }
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            if(prev==null)
            {
                prev=slow;
                slow=slow.next;
                prev.next=null;
            }
            else
            {
                ListNode tmp=slow.next;
                slow.next=prev;
                prev=slow;
                slow=tmp;
            }
            fast=fast.next.next;
        }
        
        // System.out.println(fast.val);
        // System.out.println(slow.val);
        if(fast==null)
        {
            fast=slow.next;
            slow.next=prev;
            slow=slow.next;
            while(slow!=null || fast!=null)
            {
                if(slow.val!=fast.val)
                {
                    return false;
                }
                slow=slow.next;
                fast=fast.next;
            }
            return true;
        }
        if(fast.next==null)
        {
            fast=slow.next;
            slow.next=prev;
            while(slow!=null || fast!=null)
            {
                if(slow.val!=fast.val)
                {
                    return false;
                }
                slow=slow.next;
                fast=fast.next;
            }
            return true;
        }
        return false;
    }
}