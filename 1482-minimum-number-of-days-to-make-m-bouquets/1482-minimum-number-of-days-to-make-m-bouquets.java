class Solution {
    
    public boolean valid(int[] bloomDay,int m,int k,int target)
    {
        int count=0;
        
        int current=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++)
        {
            if(bloomDay[i]>target)
            {
                count=count+current/k;
                current=0;
            }
            else
            {
                current++;
            }
        }
        count=count+current/k;
        
        return count>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l=1;
        int r=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++)
        {
            r=Math.max(r,bloomDay[i]);
        }
        int ans=Integer.MAX_VALUE;
        
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            
            if(valid(bloomDay,m,k,mid))
            {
                r=mid-1;
                ans=mid;
            }
            else
            {
                l=mid+1;
            }
        }
        
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}