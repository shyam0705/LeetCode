class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=0;
        int n=accounts.length;
        int m=accounts[0].length;
        for(int i=0;i<n;i++)
        {
            int tmp=0;
            for(int j=0;j<m;j++)
            {
                tmp=tmp+accounts[i][j];
            }
            ans=Math.max(ans,tmp);
        }
        return ans;
    }
}