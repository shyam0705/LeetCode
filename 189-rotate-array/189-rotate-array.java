class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(k==0)
        {
            return;
        }
        reverse(nums,0,n-k-1);
        int i=0;
        int j=n-1;
        while(i<k && i<=j)
        {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
        reverse(nums,0,k-1);
        reverse(nums,k,n-k-1);
    }
    public void reverse(int[] nums,int l,int r)
    {
        while(l<=r)
        {
            int tmp=nums[l];
            nums[l]=nums[r];
            nums[r]=tmp;
            l++;
            r--;
        }
    }
}