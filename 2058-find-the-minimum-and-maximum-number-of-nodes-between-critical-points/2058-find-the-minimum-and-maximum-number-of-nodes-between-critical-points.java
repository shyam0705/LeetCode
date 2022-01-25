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
    public ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev=head;
        ListNode current=head.next;
        while(current!=null)
        {
            ListNode tmp=current.next;
            current.next=prev;
            prev=current;
            current=tmp;
        }
        head.next=null;
        return prev;
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        HashSet<Integer>max=new HashSet<>();
        HashSet<Integer>min=new HashSet<>();
        ListNode current=head;
        int i=0;
        while(current.next!=null)
        {
            if(current.val>current.next.val)
            {
                max.add(i);
            }
            else if(current.val<current.next.val)
            {
                min.add(i);
            }
            i++;
            current=current.next;
        }
        head=reverse(head);
        current=head;
        int last=-1;
        int prev=-1;
        int minV=Integer.MAX_VALUE;
        int maxV=Integer.MIN_VALUE;
        while(current.next!=null)
        {
            if(current.val>current.next.val && max.contains(i))
            {
                if(last==-1)
                {
                    last=i;
                    prev=i;
                }
                else
                {
                    minV=Math.min(minV,prev-i);
                    maxV=Math.max(maxV,last-i);
                    prev=i;
                }
            }
            else if(current.val<current.next.val && min.contains(i))
            {
                if(last==-1)
                {
                    last=i;
                    prev=i;
                }
                else
                {
                    minV=Math.min(minV,prev-i);
                    maxV=Math.max(maxV,last-i);
                    prev=i;
                }
            }
            i--;
            current=current.next;
        }
        int[] ans=new int[2];
        if(maxV==Integer.MIN_VALUE)
        {
            ans[0]=-1;
            ans[1]=-1;
        }
        else
        {
            ans[0]=minV;
            ans[1]=maxV;
        }
        return ans;
        
    }
}