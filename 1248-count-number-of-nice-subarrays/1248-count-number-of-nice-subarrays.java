class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int even=0;
        int odd=0;
        int count=0;
        while(j<n)
        {
            if(nums[j]%2!=0)
            {
                odd++;
                
            }
            while(odd>k)
            {
                count=count+even;
                if(nums[i]%2!=0)
                    odd--;
                i++;
            }
            if(nums[j]%2!=0)
            {
                even=1;
            }
            else
            {
                even++;
            }
            j++;
        }
        while(odd==k)
        {
             count=count+even;
             if(nums[i]%2!=0)
                odd--;
             i++;
        }
        return count;
    }
}