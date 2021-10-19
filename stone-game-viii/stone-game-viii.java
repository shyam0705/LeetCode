class Solution {
    //O(n^2)
    // int[] sum;
    // int[] dp;
    // public int recur(int[] arr,int i,int n)
    // {
    //     if(i==n)
    //     {
    //         return 0;
    //     }
    //     if(dp[i]!=Integer.MAX_VALUE)
    //     {
    //         return dp[i];
    //     }
    //     if(i==0)
    //     {
    //        int ans=Integer.MIN_VALUE;
    //        for(int j=i+1;j<n;j++)
    //        {
    //            int tmp=sum[j]-recur(arr,j+1,n);
    //            ans=Math.max(tmp,ans);
    //        }
    //         dp[i]=ans;
    //        return ans;  
    //     }
    //     else
    //     {
    //        int ans=Integer.MIN_VALUE;
    //        for(int j=i;j<n;j++)
    //        {
    //            int tmp=sum[j]-recur(arr,j+1,n);
    //            ans=Math.max(tmp,ans);
    //        }
    //         dp[i]=ans;
    //        return ans; 
    //     }
    // }
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        // dp=new int[n];
        // dp[0]=Integer.MAX_VALUE;
        // sum=new int[n];
        // sum[0]=stones[0];
        // for(int i=1;i<n;i++)
        // {
        //     sum[i]=sum[i-1]+stones[i];
        //     dp[i]=Integer.MAX_VALUE;
        // }
        // return recur(stones,0,n);
        
        
        
        // O(n) solution
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+stones[i];
        }
        int max=sum;
        for(int i=n-2;i>=1;i--)
        {
            sum=sum-stones[i+1];
            max=Math.max(max,sum-max);
        }
        return max;
    }
}