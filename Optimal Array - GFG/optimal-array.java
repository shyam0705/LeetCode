//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long[] dp=new long[n];
        dp[0]=a[0];
        for(int i=1;i<n;i++)
        {
            dp[i]=dp[i-1]+(long)a[i];
        }
        
        long[] ans=new long[n];
        ans[0]=0;
        
        for(int i=1;i<n;i++)
        {
            if(i%2!=0)
            {
                int mid=i/2;
                long median=(long)a[mid]+(long)a[mid+1]/2;
                ans[i]=(mid+1)*median-dp[mid]-(i-mid)*median+(dp[i]-dp[mid]);
            }
            else
            {
                int mid=i/2;
                long median=(long)a[mid];
                ans[i]=(mid+1)*median-dp[mid]-(i-mid)*median+(dp[i]-dp[mid]);
            }
        }
        return ans;
    }
}
        
