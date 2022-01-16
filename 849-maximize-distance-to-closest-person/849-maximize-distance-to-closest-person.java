class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(seats[i]==0)
            {
                arr1[i]=index;
            }
            else
            {
                index=i;
            }
        }
        index=-1;
        for(int j=n-1;j>=0;j--)
        {
            if(seats[j]==0)
            {
                arr2[j]=index;
            }
            else
            {
                index=j;
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(seats[i]==0)
            {
                int tmp=Integer.MAX_VALUE;
                if(arr1[i]!=-1)
                {
                    tmp=i-arr1[i];
                }
                if(arr2[i]!=-1)
                {
                    tmp=Math.min(tmp,arr2[i]-i);
                }
                ans=Math.max(ans,tmp);
            }
        }
        return ans;
    }
}