class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n=items.length;
        int m=queries.length;
        int[] ans=new int[m];
        Arrays.sort(items,(a,b)->{
            return a[0]-b[0];
        });
        int[] dp=new int[n];
        dp[0]=items[0][1];
        for(int i=1;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],items[i][1]);
        }
        for(int i=0;i<m;i++)
        {
            int index=search(items,queries[i],0,n-1);
            if(index==-1)
            {
                ans[i]=0;
            }
            else
                ans[i]=dp[index];
        }
        return ans;
    }
    public int search(int[][] items,int target,int l,int r)
    {
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(items[mid][0]<=target)
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