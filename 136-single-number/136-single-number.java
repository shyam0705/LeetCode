class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int tmp=0;
        for(int i=0;i<n;i++)
        {
            tmp=tmp^nums[i];
        }
        return tmp;
    }
}