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
    public void reorderList(ListNode head) {
        int n=0;
        ListNode current=head;
        while(current!=null)
        {
            n++;
            current=current.next;
        }
        Stack<ListNode>s=new Stack<>();
        Queue<ListNode>q=new LinkedList<>();
        if(n%2==0)
        {
            int r=n/2;
            int i=0;
            current=head;
            while(current!=null)
            {
                if(i<r)
                {
                    q.add(current);
                }
                else
                {
                    s.add(current);
                }
                current=current.next;
                i++;
            }
        }
        else
        {
            int r=n/2;
            int i=0;
            current=head;
            while(current!=null)
            {
                if(i<=r)
                {
                    q.add(current);
                }
                else
                {
                    s.add(current);
                }
                current=current.next;
                i++;
            }
        }
        current=null;
        while(!q.isEmpty())
        {
            ListNode tmp=q.remove();
            ListNode tmp1=null;
            if(!s.isEmpty())
            {
                tmp1=s.pop();
            }
            if(current!=null)
            {
                current.next=tmp;
            }
            tmp.next=tmp1;
            current=tmp1;
            if(current!=null)
            {
                   current.next=null;
            }
         
        }
        
    }
}