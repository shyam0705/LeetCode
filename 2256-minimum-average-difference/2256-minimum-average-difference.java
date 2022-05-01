class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum=0;
        int n=nums.length;
        int min_index=0;
        long min_diff=Long.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            sum=sum+(long)nums[i];
        }
        long sumTillNow=0;
        for(int i=0;i<n;i++)
        {
            sumTillNow=sumTillNow+nums[i];
            long sum1=sumTillNow;
            long sum2=sum-sumTillNow;
            long avg1=sum1/(long)(i+1);
            long avg2=i==n-1?0:sum2/(long)(n-i-1);
            // System.out.println(Math.abs(avg1-avg2));
            if(Math.abs(avg1-avg2)<min_diff)
            {
                min_diff=Math.abs(avg1-avg2);
                min_index=i;
            }
        }
        return min_index;
    }
}