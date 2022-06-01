class Solution {
    class Node{
        int node;
        int inValue;
        Node(int node)
        {
            this.node=node;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        ArrayList<Node>g=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            g.add(new Node(i));
        }
        int m=roads.length;
        for(int i=0;i<m;i++)
        {
            g.get(roads[i][0]).inValue++;
            g.get(roads[i][1]).inValue++;
        }
        Collections.sort(g,(a,b)->{
            return b.inValue-a.inValue;
        });
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[g.get(i).node]=n-i;
        }
        long count=0;
        for(int i=0;i<m;i++)
        {
            count=count+(long)arr[roads[i][0]]+(long)arr[roads[i][1]];
        }
        return count;
    }
}