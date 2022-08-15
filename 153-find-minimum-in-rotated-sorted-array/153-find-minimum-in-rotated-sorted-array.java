class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        int ans=Integer.MAX_VALUE;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]>arr[r])
            {
                l=mid+1;
            }
            else
            {
                ans=Math.min(ans,arr[mid]);
                r=mid-1;
            }
        }
        return ans;
    }
}