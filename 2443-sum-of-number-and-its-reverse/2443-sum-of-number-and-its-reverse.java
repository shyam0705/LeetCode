class Solution {
    
    public int reverseNum(int n)
    {
        int tmp=0;
        while(n>0)
        {
            tmp=tmp*10+n%10;
            n=n/10;
        }
        return tmp;
    }
    public boolean sumOfNumberAndReverse(int num) {
        
        if(num==0)
            return true;
        for(int i=1;i<num;i++)
        {
            int first=i;
            int second=num-i;
            int reverse=reverseNum(first);
            if(second==reverse)
            {
                return true;
            }
        }
        return false;
    }
}