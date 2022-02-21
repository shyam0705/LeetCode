class Solution {
    public List<Long> maximumEvenSplit(long n) {
        if(n%2!=0)
        {
            return new ArrayList<>();
        }
        long l=2;
        long r=n/2;
        long ans=0;
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            long sum=(mid)*(mid+1);
            long rem=n-sum;
            if(rem>=0)
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        List<Long> list=new ArrayList<>();
        long rem=0;
        for(long i=1;i<=ans-1;i++)
        {
            rem=rem+2*i;
            list.add(2*i);
        }
        list.add(n-rem);
        return list;
        
    }
}