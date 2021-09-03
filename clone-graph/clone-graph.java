/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        {
            return null;
        }
        HashMap<Node,Node>mp=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            Node tmp=q.remove();
            if(!mp.containsKey(tmp))
            {
                mp.put(tmp,new Node(tmp.val));
                 for(Node el:tmp.neighbors)
                    {
                        if(!mp.containsKey(el))
                        {
                            q.add(el);
                        }
                    }
            }
           
        }
        mp.forEach((k,v)->{
            System.out.println(k.val+" "+v.val);
        });
        q.add(node);
        while(!q.isEmpty())
        {
            Node real=q.remove();
            Node duplicate=mp.get(real);
            if(duplicate.neighbors.size()==0)
            {
                for(Node el:real.neighbors)
                {
                    duplicate.neighbors.add(mp.get(el));
                    if(mp.get(el).neighbors.size()==0)
                    {
                        q.add(el);
                    }
                }
            }
        }
        return mp.get(node);
        
        
    }
}