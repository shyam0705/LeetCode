class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int current=prices[0];
        int ans=0;
        for(int i=1;i<n;i++)
        {
            if(prices[i]<current)
            {
                current=prices[i];
            }
            else
            {
                ans=Math.max(ans,prices[i]-current);
            }
        }
        return ans;
    }
}