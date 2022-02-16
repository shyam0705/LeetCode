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
    public ListNode recur(ListNode root)
    {
        if(root==null || root.next==null)
        {
            return root;
        }
        if(root.next.next==null)
        {
            ListNode tmp=root.next;
            tmp.next=root;
            root.next=null;
            return tmp;
        }
        ListNode tmp=root.next;
        ListNode tmp2=tmp.next;
        tmp.next=root;
        root.next=recur(tmp2);
        return tmp;
    }
    public ListNode swapPairs(ListNode head) {
        return recur(head);
    }
}