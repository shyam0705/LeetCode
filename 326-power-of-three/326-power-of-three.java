class Solution {
    public boolean isPowerOfThree(int n) {
        while(n>1 && n%3==0)
            n=n/3;
        if(n==1)
            return true;
        return false;
    }
}