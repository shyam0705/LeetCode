class Solution {
    public int search(int[] arr,int l,int r)
    {
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if((mid==l || arr[mid]!=arr[mid-1]) && (mid==r || arr[mid]!=arr[mid+1]))
            {
                return arr[mid];
            }
            if(mid==l ||arr[mid]==arr[mid-1])
            {
                int tmp1=((mid-2)-l)+1;
                int tmp2=(r-mid-1)+1;    
                if(tmp1>0 && tmp1%2!=0)
                {
                    r=mid-2;
                }
                else
                {
                    l=mid+1;
                }
            }
            else if(mid==r || arr[mid]==arr[mid+1])
            {
                
                int tmp1=((mid-1)-l)+1;
                int tmp2=(r-mid-2)+1;    
                if(tmp1>0 && tmp1%2!=0)
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+2;
                }
            }
        }
      
        return -1;
    }
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        return search(nums,0,n-1);
    }
}