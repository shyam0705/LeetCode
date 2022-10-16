class Solution {
    long mod=1000000007;
    long fast_exp(int exp)
    {
        if(exp==0)
            return 1;
        return (fast_exp(exp-1)*2)%mod;
    }
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer>binary=new ArrayList<>();
        
        for(int i=0;i<32;i++)
        {
            if(((n>>i)&1)==1)
            {
                binary.add(i);
            }
        }
        
        int[] prefix=new int[binary.size()];
        prefix[0]=binary.get(0);
        
       
        for(int i=1;i<binary.size();i++)
        {
            prefix[i]=prefix[i-1]+binary.get(i);
        }
        
        int m=queries.length;
        int[] ans=new int[m];
        
        for(int i=0;i<m;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            int tmp=0;
            if(l!=0)
                tmp=prefix[r]-prefix[l-1];
            else
                tmp=prefix[r];
            ans[i]=(int)(fast_exp(tmp));
        }
        return ans;
    }
}