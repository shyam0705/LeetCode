/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current=head;
        HashMap<Node,Node>mp=new HashMap<>();
        while(current!=null)
        {
            Node tmp=new Node(current.val);
            mp.put(current,tmp);
            current=current.next;
        }
        current=head;
        while(current!=null)
        {
            Node clone=mp.get(current);
            if(current.next!=null)
            {
                clone.next=mp.get(current.next);
            }
            if(current.random!=null)
            {
                clone.random=mp.get(current.random);
            }
            current=current.next;
        }
        return mp.get(head);
        
    }
}