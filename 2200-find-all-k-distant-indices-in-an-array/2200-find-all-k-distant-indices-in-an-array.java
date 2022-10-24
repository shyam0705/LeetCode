class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        int n=nums.length;
        int[] arr=new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(nums[i]==key)
            {
                int l=Math.max(i-k,0);
                int r=Math.min(i+k+1,n);
                arr[l]+=1;
                arr[r]-=1;
            }
        }
        int total=0;
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            total+=arr[i];
            if(total>0)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}