//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    
    boolean valid(int[] arr,int k,int w,long target)
    {
        int n=arr.length;
        long[] dp=new long[n+1];
        
        long count=0;
        for(int i=0;i<n;i++)
        {
            
            if(i!=0)
            {
                dp[i]+=dp[i-1];
            }
            long h=dp[i]+(long)arr[i];
            if(h<target)
            {
                
                dp[i]+=(target-h);
                dp[Math.min(i+w,n)]-=(target-h);
                count=count+(target-h);
            }
        }
        
        // System.out.println(target+" "+count+" "+k);;
        return count<=k;
        
    }
	long maximizeMinHeight(int N, int K, int W,int [] a)
    {
        //Write your code here
        long min=a[0];
        long max=a[0];
        for(int i=1;i<N;i++)
        {
            min=Math.min(min,(long)a[i]);
            max=Math.max(max,(long)a[i]);
        }
        
        long l=min;
        long r=max+K;
        
        long ans=0;
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            
            // System.out.println(l+" "+r);
            if(valid(a,K,W,mid))
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return ans;
        
        
    }
    
}
