//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    int[] parent;
    int[] rank;
    public int find(int index)
    {
        if(parent[index]==index)
        {
            return index;
        }
        parent[index]=find(parent[index]);
        return parent[index];
    }
    
    public void union(int index1,int index2)
    {
        if(rank[index1]>rank[index2])
        {
            parent[index2]=index1;
        }
        else if(rank[index2]>rank[index1])
        {
            parent[index1]=index2;
        }
        else
        {
            parent[index2]=index1;
            rank[index1]++;
        }
    }
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
        // Code Here
        parent=new int[n+1];
        rank=new int[n+1];
        
        Arrays.fill(rank,1);
        // Arrays.fill(parent,-1);
        
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
        }
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int a=mix[i][0];
            int b=mix[i][1];
            
            int parent1=find(a);
            int parent2=find(b);
            boolean check=true;
            
            for(int j=0;j<m;j++)
            {
                int u=danger[j][0];
                int v=danger[j][1];
                
                int parent3=find(u);
                int parent4=find(v);
                
                
                if((parent1==parent3 && parent2==parent4) || (parent1==parent4 && parent2==parent3))
                {
                    check=false;
                    break;
                }
            }
            
            if(check)
            {
                union(parent1,parent2);
                ans.add("Yes");
            }
            else
            {
                ans.add("No");
            }
        }
        
        return ans;
        
    }
}
