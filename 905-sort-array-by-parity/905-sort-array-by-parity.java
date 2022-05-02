class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=0;
        int n=nums.length;
        while(j<n)
        {
            if(nums[j]%2==0)
            {
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
            }
            j++;
        }
        return nums;
    }
}