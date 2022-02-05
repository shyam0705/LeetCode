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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0)
        {
            return null;
        }
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        for(int i=0;i<n;i++)
        {
            if(lists[i]!=null)
            {
                pq.add(lists[i]);
            }
            
        }
        ListNode head=new ListNode(0);
        ListNode current=head;
        while(!pq.isEmpty())
        {
            current.next=pq.remove();
            if(current.next.next!=null)
            {
                pq.add(current.next.next);
            }
            current=current.next;
        }
        return head.next;
    }
}