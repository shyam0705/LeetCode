//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int dfs(int n,int current,ArrayList<ArrayList<Integer>> g,boolean[] visited)
    {
        int count=1;
        e=e+g.get(current).size();
        for(Integer el:g.get(current))
        {
            if(!visited[el])
            {
                visited[el]=true;
                count=count+dfs(n,el,g,visited);
            }
        }
        return count;
    }
    int e;
    public int findNumberOfGoodComponent(int n, ArrayList<ArrayList<Integer>> g) {
        // Code here
        
        // System.out.println(g);
        boolean[] visited=new boolean[n+1];
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            if(!visited[i])
            {
                e=0;
                visited[i]=true;
                int count=dfs(n,i,g,visited);
                if((count*(count-1))==e)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}