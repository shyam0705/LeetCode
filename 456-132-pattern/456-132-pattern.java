class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        Stack<Integer>s1=new Stack<>();
        s1.push(0);
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        dp2[0]=nums[0];
        dp1[0]=0;
        for(int i=1;i<n;i++)
        {
            dp2[i]=Math.min(dp2[i-1],nums[i]);
            while(!s1.isEmpty() && nums[i]>=nums[s1.peek()])
            {
                s1.pop();
            }
            if(s1.isEmpty())
            {
                dp1[i]=i;
            }
            else
            {
                dp1[i]=s1.peek();
            }
            s1.push(i);
        }
        for(int i=1;i<n;i++)
        {
            if(dp1[i]!=i && dp2[dp1[i]]!=nums[dp1[i]] && dp2[dp1[i]]<nums[i])
            {
                return true;
            }
        }
        return false;
    }
}