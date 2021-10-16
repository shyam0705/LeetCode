class Solution {
    public int maxProfit(int[] arr) {
        int leastsf=arr[0];
        int n=arr.length;
        int mpist=0;
        int[] dp1=new int[n];
        int ans=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i]<leastsf)
            {
                leastsf=arr[i];
            }
            mpist=arr[i]-leastsf;
            if(mpist>dp1[i-1])
            {
                dp1[i]=mpist;
            }
            else
            {
                dp1[i]=dp1[i-1];
            }
        }
        int mpisb=0;
        int[] dp2=new int[n];
        int mostsf=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>mostsf)
            {
                mostsf=arr[i];
            }
            mpisb=mostsf-arr[i];
            if(mpisb>dp2[i+1])
            {
                dp2[i]=mpisb;
            }
            else
            {
                dp2[i]=dp2[i+1];
            }
        }
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,dp1[i]+dp2[i]);
        }
        return ans;
    }
}