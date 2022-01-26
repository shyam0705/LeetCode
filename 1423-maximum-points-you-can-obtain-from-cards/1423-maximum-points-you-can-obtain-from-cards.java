class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int[] sum=new int[n];
        sum[0]=cardPoints[0];
        for(int i=1;i<n;i++)
        {
            sum[i]=sum[i-1]+cardPoints[i];
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=k;i++)
        {
            int tmp=0;
            if(i!=0)
            {
                tmp=sum[i-1];
            }
            int fromLast=k-i;
            tmp=tmp+sum[n-1];
            if((n-fromLast-1)>=0)
            {
                tmp=tmp-sum[n-fromLast-1];
            }
            ans=Math.max(tmp,ans);
        }
        return ans;
    }
}