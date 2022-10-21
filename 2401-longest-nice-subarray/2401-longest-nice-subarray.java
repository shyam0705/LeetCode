class Solution {
    public void increase(int n,int[] arr)
    {
        for(int i=0;i<32;i++)
        {
            if(((n>>i)&1)==1)
            {
                arr[i]++;
            }
        }
    }
    public void decrease(int n,int[] arr)
    {
        for(int i=0;i<32;i++)
        {
            if(((n>>i)&1)==1)
            {
                arr[i]--;
            }
        }
    }
    
    public boolean check(int[] arr)
    {
        for(int i=0;i<32;i++)
        {
            if(arr[i]>1)
                return false;
        }
        return true;
    }
    public int longestNiceSubarray(int[] nums) {
        int[] f=new int[32];
        int i=0;
        int j=0;
        int n=nums.length;
        int ans=0;
        while(j<n)
        {
            increase(nums[j],f);   
            while(i<n && !check(f))
            {
                decrease(nums[i],f);
                i++;
            } 
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}