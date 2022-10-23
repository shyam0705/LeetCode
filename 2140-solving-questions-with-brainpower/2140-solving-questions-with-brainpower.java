class Solution {
    long[] dp;
    public long solve(int[][] arr,int index,int n)
    {
        if(index>=n)
            return 0;
        
        if(dp[index]!=-1)
            return dp[index];
        long tmp1=solve(arr,index+1,n);
        long tmp2=arr[index][0]+solve(arr,index+arr[index][1]+1,n);
        dp[index]=Math.max(tmp1,tmp2);
        return dp[index];
    }
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        dp=new long[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return solve(questions,0,n);
    }
}