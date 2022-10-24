class Solution {
    public int gcd(int a,int b)
    {
        if(a==0)
        {
            return b;
        }
        if(b==0)
        {
            return a;
        }
        if(b>a)
        {
            return gcd(b,a);
        }
        return gcd(b,a%b);
    }
    public int subarrayGCD(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            int res=0;
            for(int j=i;j<n;j++)
            {
                res=gcd(res,nums[j]);
                if(res==k)
                {
                    count++;
                }
                if(res<k)
                {
                    break;
                }
            }
        }
        return count;
    }
}