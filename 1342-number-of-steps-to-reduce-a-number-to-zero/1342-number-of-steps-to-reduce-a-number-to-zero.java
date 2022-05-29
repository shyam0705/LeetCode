class Solution {
    public int numberOfSteps(int num) {
        int[] dp=new int[num+1];
        if(num<=2)
        {
            return num;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=num;i++)
        {
            dp[i]=i%2==0?1+dp[i/2]:1+dp[i-1];
        }
        return dp[num];
    }
}