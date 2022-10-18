class Solution {
    
   public boolean isValid(int[] nums,long k)
   {
       int n=nums.length;
       long diff=Math.max(k-(long)nums[0],0);
       if(nums[0]>k)
           return false;
       for(int i=1;i<n;i++)
       {
           if(nums[i]-diff>k)
               return false;
           diff=(long)Math.max(0,k-(long)nums[i]+diff);
           
       }
       return true;
   }
    public int minimizeArrayValue(int[] nums) {
        int n=nums.length;
        // Arrays.sort(nums);
        long l=nums[0];
        long r=nums[0];
        for(int i=1;i<n;i++)
        {
            l=Math.min(l,(long)nums[i]);
            r=Math.max(r,(long)nums[i]);
        }
        long ans=0;
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            if(isValid(nums,mid))
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