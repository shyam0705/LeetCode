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
    public int len(ListNode head)
    {
        int n=0;
        while(head!=null)
        {
            head=head.next;
            n++;
        }
        return n;
    }
    public int getDecimalValue(ListNode head) {
        int ans=0;
        int n=len(head);
        int sum=0;
        while(head!=null)
        {   
            sum=sum+head.val*(1<<(n-1));
            n--;
            head=head.next;
        }
        return sum;
        
    }
}