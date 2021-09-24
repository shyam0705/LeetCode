class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==1)
        {
            if(s.charAt(0)=='0')
            {
                return 0;
            }
            return 1;
        }
        int[] dp=new int[n];
        
        dp[0]=s.charAt(0)!='0'?1:0;
        if(s.charAt(1)!='0')
        {
                dp[1]=dp[0];
        }
        if((s.charAt(0)-'0')!=0) 
        {
            if(s.charAt(0)=='1')
            {
                dp[1]=1+dp[1];
            }
            else if(s.charAt(0)=='2')
            {
                if(s.charAt(1)-'0'<=6)
                {
                    dp[1]=1+dp[1];
                }
            }
        }
        for(int i=2;i<n;i++)
        {
            if(s.charAt(i)!='0')
            {
                dp[i]=dp[i-1];
            }
            if((s.charAt(i-1)-'0')!=0) 
            {
                if(s.charAt(i-1)=='1')
                {
                    dp[i]=dp[i-2]+dp[i];
                }
                else if(s.charAt(i-1)=='2')
                {
                    if(s.charAt(i)-'0'<=6)
                    {
                         dp[i]=dp[i-2]+dp[i];
                    }
                }
            }
        }
        return dp[n-1];
        
    }
}