class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++)
        {
            int index=set(i);
            if(index==2 || index==5 || index==3 || index==7 || index==13 || index==11
              || index==17 || index==19)
            {
                count++;
            }
        }
        return count;
    }
    public int set(int n)
    {
        int count=0;
        while(n>0)
        {
            int tmp=n&1;
            count=count+tmp;
            n=n>>1;
        }
        return count;
    }
}