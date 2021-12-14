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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recur(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return new TreeNode(head.val);
        }
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        if(prev==null)
        {
            TreeNode root=new TreeNode(slow.val);
            root.right=recur(slow.next);
            return root;
        }
        else
        {
            TreeNode root=new TreeNode(slow.val);
            prev.next=null;
            root.left=recur(head);
            root.right=recur(slow.next);
            return root;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        return recur(head);
    }
}