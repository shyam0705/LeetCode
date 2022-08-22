class Solution {
    public boolean isPowerOfFour(int n) {
        if((n & (n-1))==0)
        {
             //System.out.println("hello");
            int tmp=1;
            for(int i=0;i<32;i++)
            {
                
               // System.out.println(n&tmp);
                if((n&tmp)!=0)
                {
                   
                    if(i%2==0)
                        return true;
                    return false;
                    
                }
                tmp=tmp<<1;
            }
        }
        return false;
    }
}