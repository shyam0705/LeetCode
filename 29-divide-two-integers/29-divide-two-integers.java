class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==(int)(-Math.pow(2,31)) && divisor==-1)
        {
            return (int)(Math.pow(2,31)-1);
        }
         if(divisor==1)
        {
          return dividend;
        }
        if(divisor==-2147483648)
        {
            if(dividend==-2147483648)
            {
                return 1;
            }
            return 0;
        }
        if(dividend==-2147483648)
        {
            int d1=Math.abs(dividend+1);
            int d2=Math.abs(divisor);
            int q=0;
            while(d1>=d2)
            {
                d1=d1-d2;
                q++;
            }
            if((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
            {
                return (d1==d2-1)?q+1:q;
            }
            return (d1==d2-1)?-(q+1):-q;
        }
        int d1=Math.abs(dividend);
        int d2=Math.abs(divisor);
        int q=0;
        while(d1>=d2)
        {
            d1=d1-d2;
            q++;
        }
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
        {
            return q;
        }
        return -q;
    }
}