class Solution {
    public boolean valid(int[] arr,int target,int k)
    {
        int n=arr.length;
        int tmp=0;
        for(int i=0;i<n;i++)
        {
    
            tmp=tmp+(arr[i]+k-1)/k;
        }
        if(k==3)
        {
            System.out.println(tmp);
        }
        
        return tmp<=target;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int n=piles.length;
        int r=piles[0];
        for(int i=1;i<n;i++)
        {
            r=Math.max(piles[i],r);
        }
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(valid(piles,h,mid))
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