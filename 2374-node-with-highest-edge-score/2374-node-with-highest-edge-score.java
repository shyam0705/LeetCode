class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        long[] dp=new long[n];
        
        for(int i=0;i<n;i++)
        {
            dp[edges[i]]=dp[edges[i]]+(long)i;
        }
        long ans=dp[0];
        int index=0;
        
        for(int i=1;i<n;i++)
        {
            if(dp[i]>ans)
            {
                ans=dp[i];
                index=i;
            }
        }
        return index;
        
    }
}