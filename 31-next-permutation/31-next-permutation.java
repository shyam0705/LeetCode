class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int j=n-2;
        while(j>=0 && nums[j]>=nums[j+1])
        {
            j--;
        }
        int i=n-1;
        if(j>=0)
        {

            while(nums[i]<=nums[j])
            {
                i--;
            }
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        i=j+1;
        j=n-1;
        while(i<=j)
        {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }
}