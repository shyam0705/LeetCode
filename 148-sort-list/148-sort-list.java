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
    public ListNode midNode(ListNode head,ListNode tail)
    {
        ListNode f=head;
        ListNode s=head;
        while(f!=tail && f.next!=tail)
        {
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    public ListNode mergeSort(ListNode head,ListNode prev)
    {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return head;
        }
        if(head==prev)
        {
            return head;
        }
        ListNode mid=midNode(head,prev);
        ListNode tmp=mid.next;
        mid.next=null;
        ListNode head1=mergeSort(head,mid);
        ListNode head2=mergeSort(tmp,prev);
        return merge(head1,head2);
    }
    public ListNode merge(ListNode head1,ListNode head2)
    {
        if(head1==null)
        {
            return head2;
        }
        if(head2==null)
        {
            return head1;
        }
        ListNode head=new ListNode(0);
        ListNode current=head;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                current.next=head1;
                current=current.next;
                head1=head1.next;
            }
            else{
                current.next=head2;
                current=current.next;
                head2=head2.next;
            }
        }
        while(head1!=null)
        {
            current.next=head1;
            head1=head1.next;
            current=current.next;
        }
        while(head2!=null)
        {
            current.next=head2;
            head2=head2.next;
            current=current.next;
        }
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        ListNode current=head;
        if(current==null)
        {
            return null;
        }
        while(current.next!=null)
        {
            current=current.next;
        }
        return mergeSort(head,current);
    }
}