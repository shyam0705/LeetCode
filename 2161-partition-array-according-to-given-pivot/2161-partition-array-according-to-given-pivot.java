class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] ans=new int[n];
        int i=-1;
        int j=n;
        int k=0;
        while(k<n)
        {
            if(nums[k]<pivot)
            {
                i++;
                ans[i]=nums[k];
            }
            if(nums[k]>pivot)
            {
                j--;
                ans[j]=nums[k];
            }
            k++;
        }
        int l=j;
        int r=n-1;
        while(l<=r)
        {
            int tmp=ans[l];
            ans[l]=ans[r];
            ans[r]=tmp;
            l++;
            r--;
        }
        k=i+1;
        while(k<j)
        {
            ans[k]=pivot;
            k++;
        }
        return ans;
    }
}