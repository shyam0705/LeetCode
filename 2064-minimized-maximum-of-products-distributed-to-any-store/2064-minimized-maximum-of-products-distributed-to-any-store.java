class Solution {
    public boolean isPossible(int[] arr,int n,int m,int target){
        int count=0;
        for(int i=0;i<m;i++)
        {
            count=count+(arr[i]+target-1)/target;
        }
       return count<=n;
    }
    public int minimizedMaximum(int n, int[] arr) {
        int m=arr.length;
        int l=1;
        int r=arr[0];
        for(int i=1;i<m;i++)
        {
            r=Math.max(arr[i],r);
        }
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(isPossible(arr,n,m,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
}