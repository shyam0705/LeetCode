class Solution {
    public int binarySearch(int[] arr,int k)
    {
        int l=0;
        int r=arr.length-1;
        int ans=arr.length;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]>k)
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
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++)
        {
            ans[i]=binarySearch(prefix,queries[i]);
        }
        return ans;
    }
}