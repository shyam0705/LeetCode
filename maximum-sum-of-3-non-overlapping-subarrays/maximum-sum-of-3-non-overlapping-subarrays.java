class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        int[] prefix=new int[n];
        int[] start=new int[n];
        int[] end=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=0;i<n;i++)
        {
            if(i<(k-1))
            {
                dp1[i]=0;
            }
            else if(i==(k-1))
            {
                start[i]=0;
                dp1[i]=prefix[i];
            }
            else
            {
                int tmp=prefix[i]-prefix[i-k];
                if(tmp>dp1[i-1])
                {
                    dp1[i]=tmp;
                    start[i]=i-k+1;
                }
                else
                {
                    dp1[i]=dp1[i-1];
                    start[i]=start[i-1];
                }
            }
        }
        int[] suffix=new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            suffix[i]=suffix[i+1]+nums[i];
        }
        for(int i=n-1;i>=0;i--)
        {
            if((i+k)>n)
            {
                dp2[i]=0;
            }
            else if((i+k)==n)
            {
                dp2[i]=suffix[i];
                end[i]=i;
            }
            else
            {
                int tmp=suffix[i]-suffix[i+k];
                if(tmp>=dp2[i+1])
                {
                    dp2[i]=tmp;
                    end[i]=i;
                }
                else
                {
                    dp2[i]=dp2[i+1];
                    end[i]=end[i+1];
                }
                
            }
        }
        int max=Integer.MIN_VALUE;
        int[] ans=new int[3];
        for(int i=k;i<=(n-2*k);i++)
        {
            int tmp=prefix[i+k-1]-prefix[i-1]+dp1[i-1]+dp2[i+k];
            if(tmp>max)
            {
                ans[1]=i;
                ans[0]=start[i-1];
                ans[2]=end[i+k];
                max=tmp;
            }
        }
       return ans;
    }
}