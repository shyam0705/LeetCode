class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int count=0;
        while(j<n)
        {
        
            while(j<n && nums[i]==nums[j])
            {
                j++;
            }
            count=j-i;
            
            if(count>2)
            {
                int tmp=nums[j-1];
                int l=i+2;
                int r=j;
                while(r<n)
                {
                   nums[l]=nums[r];
                    l++;
                    r++;
                }
                i=i+2;
                j=i;
                n=n-count+2;
                count=0;
            }
            else
            {
                i=j;
                count=0;
            }
            
        }
        return n;
    }
}