class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return new ArrayList<>();
        }
        int last=0;
        int j=1;
        List<String>l=new ArrayList<>();
        while(j<n)
        {
            if(nums[j]==nums[j-1]+1)
            {
                j++;
            }
            else
            {
                if(last==j-1)
                {
                    String tmp=Integer.toString(nums[last]);
                    l.add(tmp);
                }
                else
                {
                    String tmp=Integer.toString(nums[last])+"->"+Integer.toString(nums[j-1]);
                    l.add(tmp);
                }
                last=j;
                j++;
            }
        }
        if(last==n-1)
        {
            l.add(Integer.toString(nums[n-1]));
        }
        else
        {
            String tmp=Integer.toString(nums[last])+"->"+Integer.toString(nums[n-1]);
            l.add(tmp);
        }
        return l;
    }
}