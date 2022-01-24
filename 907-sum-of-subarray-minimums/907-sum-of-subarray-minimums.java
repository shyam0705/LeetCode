class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long[] dp=new long[n];
        long mod=1000000007;
        Stack<Integer>s=new Stack<>();
        s.add(0);
        long ans=arr[0];
        dp[0]=ans;
        for(int i=1;i<n;i++)
        {
            while(!s.isEmpty() && arr[s.peek()]>arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                dp[i]=((i+1)*arr[i])%mod;
            }
            else
            {
                dp[i]=(dp[s.peek()]+((i-s.peek())*arr[i]))%mod;
            }
            s.push(i);
            ans=(ans+dp[i])%mod;
        }
        return (int)ans;
        
    }
}