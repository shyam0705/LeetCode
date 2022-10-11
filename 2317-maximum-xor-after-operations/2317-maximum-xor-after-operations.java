class Solution {
    public int maximumXOR(int[] nums) {
        boolean[] arr=new boolean[32];
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<32;j++)
            {
                if(((nums[i]>>j)&1)==1)
                {
                    arr[j]=true;
                }
            }
        }
        int ans=0;
        for(int i=0;i<32;i++)
        {
            if(arr[i])
                ans=ans+(1<<i);
        }
        return ans;
    }
}
