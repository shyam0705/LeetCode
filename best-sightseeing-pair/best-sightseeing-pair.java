class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int ans=Integer.MIN_VALUE;
        int i=n-2;
        int j=n-1;
        while(i>=0)
        {
            int diff=values[i]+values[j]+i-j;
            ans=Math.max(ans,diff);
            if(values[i]>=(values[j]+i-j))
            {
                j=i;
            }
            i--;
        }
        return ans;

    }
}