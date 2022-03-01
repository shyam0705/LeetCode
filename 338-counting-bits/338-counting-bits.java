class Solution {
    public int count(int n)
    {
        int c=0;
        while(n>0)
        {
            c=c+(n&1);
            n=n>>1;
        }
        return c;
    }
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=count(i);
        }
        return arr;
    }
}