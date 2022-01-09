class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                k++;
            }
        }
        int[] arr=new int[2*n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=nums[i%n];
        }
        int tmp=0;
        for(int i=0;i<k;i++)
        {
            if(arr[i]!=1)
            {
                tmp++;
            }
        }
        int ans=tmp;
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]!=1)
            {
                tmp++;
            }
            if(arr[i-k]==0)
            {
                tmp--;
            }
            ans=Math.min(ans,tmp);
        }
        return ans;
        
    }
}