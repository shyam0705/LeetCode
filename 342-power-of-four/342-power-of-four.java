class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0)
            return false;
        if((n & (n-1))==0 && Math.sqrt(n)==(int)Math.sqrt(n))
        {
             return true;
        }
        return false;
    }
}