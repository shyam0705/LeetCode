class Solution {
    public int checkBit(int num,int i)
    {
        return ((num>>i)&1);
    }
    public int countSetBit(int num)
    {
        int count=0;
        for(int i=0;i<32;i++)
        {
            int tmp=(num>>i)&1;
            count=count+tmp;
        }
        return count;
    }
    public int maximumGood(int[][] arr) {
        int n=arr.length;
        int tmp=(1<<n)-1;
        int ans=0;
        while(tmp>0)
        {
            boolean check=true;
            for(int i=0;i<n;i++)
            {
                if(checkBit(tmp,i)==1)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(arr[i][j]!=2 && checkBit(tmp,j)!=arr[i][j])
                        {
                            check=false;
                            break;
                        }
                    }
                }
            }
            if(check)
            {
                ans=Math.max(ans,countSetBit(tmp));
            }
            tmp--;
        }
        return ans;
    }
}