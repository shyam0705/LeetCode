class Solution {
    HashMap<Integer,int[]>mp;
    public int[] dfs(ArrayList<ArrayList<Integer>>graph,int i,int parent)
    {
        int key=i*(100000)+parent;
        if(mp.containsKey(key))
        {
            return mp.get(key);
        }
        int sum=0;
        int count=0;
        for(Integer el:graph.get(i))
        {
            if(el!=parent)
            {
                int[] tmp=dfs(graph,el,i);
                count=count+1+tmp[1];
                sum=sum+tmp[0];
            }
        }
        sum=sum+count;
        int[] arr={sum,count};
        mp.put(key,arr);
        return arr;
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        mp=new HashMap<>();
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        int m=edges.length;
        for(int i=0;i<m;i++)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            int[] tmp=dfs(graph,i,-1);
            ans[i]=tmp[0];
        }
        return ans;
    }
}