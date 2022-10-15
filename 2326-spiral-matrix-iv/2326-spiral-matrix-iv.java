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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[i][j]=-1;
            }
        }
        int r1=0;
        int r2=m-1;
        int c1=0;
        int c2=n-1;
        
        int count=0;
        int total=m*n;
        while(count<total && head!=null)
        {
            int i=c1;
            while(count<total && head!=null && i<=c2)
            {
                ans[r1][i]=head.val;
                head=head.next;
                i++;
                count++;
            }
            r1++;
            i=r1;
            while(count<total && head!=null && i<=r2)
            {
                ans[i][c2]=head.val;
                head=head.next;
                i++;
                count++;
            }
            c2--;
            i=c2;
            while(count<total && head!=null && i>=c1)
            {
                ans[r2][i]=head.val;
                head=head.next;
                i--;
                count++;
            }
            r2--;
            i=r2;
            while(count<total && head!=null && i>=r1)
            {
                ans[i][c1]=head.val;
                head=head.next;
                i--;
                count++;
            }
            c1++;
        }
        return ans;
    }
}