class Solution {
    
    public int search(int k,int[] arr,long target)
    {
        int l=0;
        int n=arr.length;
        int r=n-1;
        int ans=n;
        
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            long tmp=(long)arr[mid]*(long)k;
            if(tmp>=target)
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
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int[] ans=new int[n];
        Arrays.sort(potions);
        
        int m=potions.length;
        for(int i=0;i<n;i++)
        {
            ans[i]=m-search(spells[i],potions,success);
        }
        return ans;
    }
}