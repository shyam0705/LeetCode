class Solution {
    long[] dp;
    public long recur(int n,int i,int[][] rides)
    {
        if(i>=n)
        {
            return 0;
        }
        if(i==n-1)
        {
            return (long)(rides[i][1]-rides[i][0]+rides[i][2]);
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        long tmp=recur(n,i+1,rides);
        int l=i+1;
        int r=n;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(rides[mid][0]<rides[i][1])
            {
                l=mid+1;
            }
            else
            {
                r=mid;
            }
        }
        long tmp2=(rides[i][1]-rides[i][0]+rides[i][2])+recur(n,r,rides);
        long ans=Math.max(tmp,tmp2);
        dp[i]=ans;
        return ans;
        
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        n=rides.length;
        Arrays.sort(rides,(a,b)->{
            return a[0]-b[0];
        });
        dp=new long[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return recur(n,0,rides);
        
    }
}