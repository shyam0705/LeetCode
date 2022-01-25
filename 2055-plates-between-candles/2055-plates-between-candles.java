class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        dp1[n-1]=(s.charAt(n-1)=='|'?n-1:-1);
        dp2[0]=(s.charAt(0)=='|'?0:-1);
        for(int i=n-2;i>=0;i--)
        {
            if(s.charAt(i)=='|')
            {
                dp1[i]=i;
            }
            else
            {
                dp1[i]=dp1[i+1];
            }
        }
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)=='|')
            {
                dp2[i]=i;
            }
            else
            {
                dp2[i]=dp2[i-1];
            }
        }
        int[] dp=new int[n];
        dp[0]=(s.charAt(0)=='*'?1:0);
        for(int i=1;i<n;i++)
        {
            dp[i]=dp[i-1];
            if(s.charAt(i)=='*')
            {
                dp[i]++;
            }
        }
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++)
        {
            int l=dp1[queries[i][0]];
            int r=dp2[queries[i][1]];
            if(l>=r || l==-1 || r==-1)
            {
                ans[i]=0;
            }
            else
            {
                if(l==0)
                {
                    ans[i]=dp[r];
                }
                else
                {
                    ans[i]=dp[r]-dp[l-1];
                }
            }
        }
        return ans;
    }
}