class Solution {
    public int arrangeCoins(int n) {
        int count=0;
        int l=0;
        int r=n;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            long sum=((long)mid*(long)(mid+1))/(long)2;
            if(sum<=n)
            {
                count=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
            
        }
        return count;
    }
}