class Solution {
    int[][] dp;
    public int recur(int left,int right,int l,int r,int[] arr)
    {
        if((right-left<=1) || l>r)
        {
            return 0;
        }
        if(dp[l][r]!=-1)
            return dp[l][r];
        int ans=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++)
        {
            int cost=recur(left,arr[i],l,i-1,arr)+recur(arr[i],right,i+1,r,arr)+(right-left);
            ans=Math.min(ans,cost);
        }
        dp[l][r]=ans;
        return ans;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m=cuts.length;
        dp=new int[m][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return recur(0,n,0,m-1,cuts);
        
    }
}