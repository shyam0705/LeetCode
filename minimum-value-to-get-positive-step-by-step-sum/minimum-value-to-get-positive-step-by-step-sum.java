class Solution {
    public int minStartValue(int[] nums) {
        int n=nums.length;
        int start=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+nums[i];
            if(sum<1)
            {
                start=start+(1-sum);
                sum=1;
            }
        }
        return Math.max(start,1);
    }
}