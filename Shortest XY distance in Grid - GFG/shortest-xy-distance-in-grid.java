//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
}

class Solution {
    
    
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // code here
        
        Queue<Pair>q=new LinkedList<>();
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(grid.get(i).get(j)=='Y')
                {
                    q.add(new Pair(i,j));
                }
            }
        }
        
        int dis=0;
        
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,1,-1};
        while(!q.isEmpty())
        {
            int n=q.size();
            dis++;
            for(int i=0;i<n;i++)
            {
                Pair tmp=q.remove();
                for(int k=0;k<4;k++)
                {
                    int x=arr1[k]+tmp.x;
                    int y=arr2[k]+tmp.y;
                    if(x>=0 && y>=0 && x<N && y<M)
                    {
                        if(grid.get(x).get(y)=='X')
                        {
                            return dis;
                        }
                        if(grid.get(x).get(y)=='O')
                        {
                            q.add(new Pair(x,y));
                            grid.get(x).set(y,'Z');
                        }
                    }
                }
            }
        }
        
        return dis;
        
    }
};