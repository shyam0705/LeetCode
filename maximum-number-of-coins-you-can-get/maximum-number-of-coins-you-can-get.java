class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length;
        int i=0;
        int j=n-1;
        int sum=0;
        while((i+1)<=j)
        {
            sum=sum+piles[j-1];
            j=j-2;
            i++;
        }
        return sum;
    }
}