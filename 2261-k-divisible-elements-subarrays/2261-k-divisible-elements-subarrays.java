class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n=nums.length;
        HashSet<String>hs=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int count=0;
            String current="";
            int j=i;
            while(j<n && count<=k)
            {
                if(nums[j]%p==0)
                {
                    count++;
                }
                current=current+"$"+nums[j];
                if(count<=k && !hs.contains(current))
                {
                    ans++;
                }
                hs.add(current);
                j++;
            }
        }
        return ans;
        
    }
}