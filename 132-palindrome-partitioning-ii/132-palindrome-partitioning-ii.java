class Solution {
   
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n+1][n];
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<n-i+1;j++)
            {
                if(i==1)
                {
                    dp[i][j]=true;
                }
                else
                {
                    if(s.charAt(j)==s.charAt(j+i-1))
                    {
                        if(i!=2)
                        {
                            dp[i][j]=dp[i-2][j+1];
                        }
                        else
                        {
                            dp[i][j]=true;
                        }
                        
                        
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                // System.out.println(dp[i][j]);
            }
        }
        
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                ans[i]=0;
            }
            else
            {
                ans[i]=i+1;
                for(int j=i;j>=0;j--)
                {
                    if(dp[i-j+1][j])
                    {
                        if(j==0)
                        {
                            ans[i]=0;
                        }
                        else
                        {
                            ans[i]=Math.min(ans[i],1+ans[j-1]);
                        }
                    }
                } 
            }
            
        }
        return ans[n-1];
    }
}