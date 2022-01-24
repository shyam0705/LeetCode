class Solution {
    public int search(int[][] events,int target,int l,int r)
    {
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(events[mid][0]>target)
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
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->{
            // if(a[0]==b[0])
            // {
            //     return a[2]-b[2];
            // }
            return a[0]-b[0];
        });
        int[] dp=new int[n];
        dp[n-1]=events[n-1][2];
        for(int i=n-2;i>=0;i--)
        {
            dp[i]=Math.max(dp[i+1],events[i][2]);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int target=events[i][1];
            int index=search(events,target,i+1,n-1);
            if(index!=-1)
            {
                ans=Math.max(ans,events[i][2]+dp[index]);
            }
            else
            {
                ans=Math.max(ans,events[i][2]);
            }
        }
        return ans;
    }
}