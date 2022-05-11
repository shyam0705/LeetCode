class Solution {
    public int recur(int n,int k)
    {
        if(n==1)
        {
            return k;
        }
        int sum=0;
        for(int i=1;i<=k;i++)
        {
            sum=sum+recur(n-1,k-i+1);
        }
        return sum;
    }
    public int countVowelStrings(int n) {
        return recur(n,5);
    }
}