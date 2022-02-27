class Solution {
    public boolean isValid(int[] time,long total,long k)
    {
        long count=0;
        for(int i=0;i<time.length;i++)
        {
            count=count+(k)/(long)time[i];
        }
        return count>=total;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int n=time.length;
        long l=1;
        long r=(long)Math.pow(10,14);
        long ans=-1;
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            if(isValid(time,(long)totalTrips,mid))
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