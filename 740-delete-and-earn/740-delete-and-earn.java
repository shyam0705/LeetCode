class Solution {
    public int recur(int[] arr,int i,int[] dp)
    {
        if(i<0)
        {
            return 0;
        }
        if(i==0)
        {
            return arr[0];
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int j=i-1;
        while(j>=0 && arr[j]==arr[i])
        {
            j--;
        }
        int tmp=(i-j)*arr[i];
        int tmp1=recur(arr,j,dp);
        while(j>=0 && arr[j]==(arr[i]-1))
        {
            j--;
        }
        int tmp2=tmp+recur(arr,j,dp);
        dp[i]=Math.max(tmp1,tmp2);
        return dp[i];
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return recur(nums,nums.length-1,dp);
        
    }
}