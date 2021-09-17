class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int j=0;j<32;j++)
        {
            int count=0;
            for(int i=0;i<n;i++)
            {
                int tmp=nums[i]&1;
                if(tmp==1)
                {
                    count++;
                }
                nums[i]=nums[i]>>1;
            }
            count=count%3;
            ans=(ans | (count<<j));
        }
        return ans;
    }
}