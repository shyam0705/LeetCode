class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        if(n<=2)
            return 0;
        int ans=0;
        int left_max=arr[0];
        int right_max=arr[n-1];
        int l=1;
        int r=n-2;
        while(l<=r)
        {
            if(left_max>right_max)
            {
                int h=right_max-arr[r];
                
                if(h>0)
                    ans=ans+h;
                else
                    right_max=arr[r];
                
                r--;
            }
            else
            {
                int h=left_max-arr[l];
                if(h>0)
                    ans=ans+h;
                else
                    left_max=arr[l];
                
                l++;
            }
        }
        return ans;
    }
}