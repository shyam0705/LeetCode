class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==0)
                sum=sum+nums[i];
        }
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++)
        {
            int val=queries[i][0];
            int index=queries[i][1];
            int old=nums[index];
            int neww=old+val;
            nums[index]=neww;
            if(old%2==0)
                sum=sum-old;
            if(neww%2==0)
                sum=sum+neww;
            ans[i]=sum; 
        }
        return ans;
    }
}