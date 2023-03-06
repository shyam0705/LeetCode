//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        // code here
        int[] dp=new int[32];
        for(int i=31;i>=0;i--)
        {
            if(((n>>i)&1)==1)
            {
                dp[i]=1;
            }
            if(i!=31 && dp[i]!=0)
            {
                dp[i]+=dp[i+1];
            }
            
            if(dp[i]==3)
            {
                dp[i]=0;
            }
        }
        
        int tmp=0;
        for(int i=0;i<32;i++)
        {
            if(dp[i]>=1 && dp[i]<3)
            {
               tmp=tmp+(1<<i); 
            }
        }
        return tmp;
    }
}
        
