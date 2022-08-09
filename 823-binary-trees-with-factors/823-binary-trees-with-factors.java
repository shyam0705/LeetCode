class Solution {
    HashMap<Integer,Integer>mp;
    long[] dp;
    long mod;
    public long recur(int[] arr,int x,int n)
    {
        if(dp[x]!=-1)
        {
            return dp[x];
        }
        long count=1;
        for(int i=0;i<x;i++)
        {
            if(arr[x]%arr[i]==0)
            {
                int tmp=arr[x]/arr[i];
                if(mp.containsKey(tmp))
                {
                    count=(count+(recur(arr,i,n)*recur(arr,mp.get(tmp),n))%mod)%mod;
                }
            }
                
        }
        dp[x]=count;
        return count;
    }
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        mp=new HashMap<>();
        mod=1000000007;
        dp=new long[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
            mp.put(arr[i],i);
        }
        long ans=0;
        for(int i=0;i<n;i++)
        {
            long count=recur(arr,i,n);
            ans=(ans+count)%mod;
        }
        return (int)ans;
    }
}