class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        int n=nums.length;
        // int count=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0 && nums[i]>sum)
            {
                sum=nums[i];
                count++;
            }
        }
        return count;
    }
}