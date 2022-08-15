class Solution {
    public boolean search(int[] arr, int target) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            if(arr[mid]==arr[r])
            {
                r--;
            }
            else if (target>arr[r])
            {
                if(arr[mid]>arr[r] && target>arr[mid])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }
            else
            {
                if(arr[mid]<arr[r] && target<arr[mid])
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
        }
        return false;
    }
}