class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int max_abs=Integer.MAX_VALUE;
        int s=0;
        for(int i=0;i<n-2;i++)
        {
            int j=i+1;
            int k=n-1;
            
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target)
                {
                    return target;
                }
                if(sum>target)
                {
                    int abs=sum-target;
                    if(abs<max_abs)
                    {
                        max_abs=abs;
                        s=sum;
                    }
                    k--;
                }
                else
                {
                    int abs=Math.abs(sum-target);
                    if(abs<max_abs)
                    {
                        max_abs=abs;
                        s=sum;
                    }
                    j++;  
                }
            }
        }
        return s;
    }
}