class Solution {
    public long[] sumOfThree(long num) {
        long l=-1;
        long h=num+1;
        long[] ans=new long[3];
        while(l<=h)
        {
            long tmp=l+(h-l)/2;
            if((3*tmp-3)==num)
            {
                ans[0]=tmp-2;
                ans[1]=tmp-1;
                ans[2]=tmp;
                return ans;
            }
            else if((3*tmp-3)>num)
            {
                h=tmp-1;
            }
            else
            {
                l=tmp+1;
            }
        }
        return new long[0];
    }
}