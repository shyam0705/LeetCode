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
    int i;
    HashMap<Integer,ListNode>mp;
    public Solution(ListNode head) {
        i=0;
        mp=new HashMap<>();
        ListNode current=head;
        while(current!=null)
        {
            mp.put(i,current);
            i++;
            current=current.next;
        }
        
    }
    
    public int getRandom() {
        Random random = new Random();   
        int j=random.nextInt(i);   
        if(j<i)
        {
            return mp.get(j).val;
        }
        return -1;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */