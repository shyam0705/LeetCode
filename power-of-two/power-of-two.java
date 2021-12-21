class Solution {
    public boolean isPowerOfTwo(int n) {
        long a=(long)n;
        long t=a-1;
        if(n==0)
        {
            return false;
        }
        if(n==1)
        {
            return true;
        }
        if((a&t)==0)
        {
            return true;
        }
        return false;
    }
}