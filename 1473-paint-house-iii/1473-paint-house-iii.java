class Solution {
    int[][][] dp;
    public int recur(int[] houses,int[][] cost,int n,int m,int index,int k,int count)
    {
        if(count>k)
        {
            return -1;
        }
        if(index==n)
        {
            if(count==k)
            {
                return 0;
            }
            return -1;
        }
        if(index!=0 && dp[index][houses[index-1]][count]!=-2)
        {
            return dp[index][houses[index-1]][count];
        }
        int ans=Integer.MAX_VALUE;
        if(houses[index]!=0)
        {
            if(index==0 || houses[index]==houses[index-1])
            {
                if(index==0)
                {
                     return recur(houses,cost,n,m,index+1,k,count);
                }
                dp[index][houses[index-1]][count]=recur(houses,cost,n,m,index+1,k,count);
                return dp[index][houses[index-1]][count];
            }
            else
            {
                dp[index][houses[index-1]][count]=recur(houses,cost,n,m,index+1,k,count+1);
                return dp[index][houses[index-1]][count];
            }
        }
        else
        {
             for(int i=0;i<m;i++)
            {
                if(index==0 || (i+1)==houses[index-1])
                {
                    houses[index]=i+1;
                    int tmp=recur(houses,cost,n,m,index+1,k,count);
                    if(tmp!=-1)
                    {
                        ans=Math.min(ans,tmp+cost[index][i]);
                    }
                    houses[index]=0;

                }
                else
                {
                     houses[index]=i+1;
                     int tmp= recur(houses,cost,n,m,index+1,k,count+1);
                     if(tmp!=-1)
                     {
                        ans=Math.min(ans,tmp+cost[index][i]);
                     }
                     houses[index]=0;
                }
            }
        }
        if(index==0)
            return ans==Integer.MAX_VALUE?-1:ans;
        dp[index][houses[index-1]][count]=(ans==Integer.MAX_VALUE?-1:ans);
        return dp[index][houses[index-1]][count];
    }
    public int minCost(int[] houses, int[][] cost, int n, int m, int target) {
        dp=new int[101][21][101];
        for(int i=0;i<=100;i++)
        {
            for(int j=0;j<=20;j++)
            {
                for(int k=0;k<=100;k++)
                {
                    dp[i][j][k]=-2;
                }
            }
        }
        return recur(houses,cost,n,m,0,target,1);
        
    }
}