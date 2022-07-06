class Solution {
    public int fib(int n) {
        if(n<=1)
        {
            return n;
        }
        int last=1;
        int second_last=0;
        for(int i=2;i<=n;i++)
        {
            int tmp=last;
            last=last+second_last;
            second_last=tmp;
        }
        return last;
    }
}