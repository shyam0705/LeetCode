class Solution {
    int n;
    int[][] dp;
    public int recur(int i,char prev,String colors,int[] neededTime)
    {
        if(i>=n)
            return 0;
        char current=colors.charAt(i);
        if(prev!='A' && dp[i][prev-'a']!=-1)
        {
            return dp[i][prev-'a'];
        }
        int cost=0;
        if(current==prev)
        {
                                                  cost=cost+recur(i+1,prev,colors,neededTime)+neededTime[i];
        }
        else
        {
            cost=cost+Math.min(
              recur(i+1,prev,colors,neededTime)+neededTime[i],
              recur(i+1,current,colors,neededTime)
            );
        }
        if(prev!='A')
            dp[i][prev-'a']=cost;
        return cost;
    }
    public int minCost(String colors, int[] neededTime) {
        n=colors.length();
        dp=new int[n][26];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<26;j++)
            {
                dp[i][j]=-1;
            }
        }
        return recur(0,'A',colors,neededTime);
    }
}