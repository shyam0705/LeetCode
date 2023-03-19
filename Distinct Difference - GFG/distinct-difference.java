//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        
      int n=N;
      int[] dp1=new int[n];
      
      ArrayList<Integer>ans=new ArrayList<>();
      HashSet<Integer>hs=new HashSet<>();
      for(int i=0;i<N;i++)
      {
          dp1[i]=hs.size();
          hs.add(A[i]);
      }
      
      int[] dp2=new int[n];
      hs.clear();
      for(int i=n-1;i>=0;i--)
      {
          dp2[i]=hs.size();
          hs.add(A[i]);
      }
      
      for(int i=0;i<n;i++)
      {
          ans.add(dp1[i]-dp2[i]);
      }
      
      return ans;
        
    }
}
        
