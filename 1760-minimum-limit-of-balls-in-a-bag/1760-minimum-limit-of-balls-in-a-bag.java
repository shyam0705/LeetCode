class Solution {
    public boolean valid(int[] nums,long k,long max)
    {
        long count=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>max)
                count=count+((long)nums[i]/max)-(nums[i]%max==0?1:0);
        }
        return count<=k;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=(long)nums[i];
        }
        long l=1;
        long r=sum;
        long ans=0;
        
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            if(valid(nums,(long)maxOperations,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return (int)ans;
    }
}