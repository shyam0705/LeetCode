class Solution {
    public int maximumGroups(int[] grades) {
        int n=grades.length;
        int l=1;
        int r=n;
        int ans=0;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            long sum=(long)(mid)*(long)(mid+1)/2;
            if(sum<=n)
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return ans;
    }
}