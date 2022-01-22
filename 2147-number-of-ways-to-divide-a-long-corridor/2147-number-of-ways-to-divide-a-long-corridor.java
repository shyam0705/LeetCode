class Solution {
    int n;
    long mod=1000000007;
    int[] dp;
    public int recur(char[] arr,int index)
    {
        
        if(index>=n)
        {
            return 1;
        }
        if(index==n-1)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        if(index==n-2)
        {
            if(arr[index]=='S' && arr[index+1]=='S')
            {
                dp[index]=1;
                return 1;
            }
            else
            {
                dp[index]=0;
                return 0;
            }
        }
        int count_s=0;
        int i=index;
        long count=0;
        while(i<n && count_s<=2)
        {
            if(arr[i]=='S')
            {
                count_s++;
            }
            if(count_s==2)
            {
                long tmp_count=1;
                i++;
                while(i<n && arr[i]!='S')
                {
                    tmp_count++;
                    i++;
                }
                int tmp=0;
                if(i<n)
                {
                    tmp=recur(arr,i);
                    if(tmp!=0)
                    {
                        tmp_count=(tmp_count*(long)tmp)%mod;
                    }
                    else
                    {
                        tmp_count=0;
                    }
                }
                else
                {
                    tmp_count=1;
                }
                count=(count+tmp_count)%mod;
                break;
            }
            else
            {
               i++; 
            }
            
        }
       dp[index]=(int)count;
        return dp[index];
    }
    public int numberOfWays(String corridor) {
        n=corridor.length();
        dp=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        
        char[] arr=corridor.toCharArray();
        return recur(arr,0);
    }
}