class Solution {
    int n,w;
    int[] dp;
    public int recur(int[][] books,int index)
    {
        if(index>=n)
        {
            return 0;
        }
        if(index==n-1)
        {
            return books[index][1];
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        int j=index;
        int max_height=Integer.MIN_VALUE;
        int width=0;
        int ans=Integer.MAX_VALUE;
        while(j<n)
        {
            width=width+books[j][0];
            max_height=Math.max(max_height,books[j][1]);
            if(width<=w)
            {
                int tmp=max_height+recur(books,j+1);
                ans=Math.min(tmp,ans);
            }
            else
            {
                break;
            }
            j++;
        }
        dp[index]=ans;
        return ans;
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n=books.length;
        w=shelfWidth;
        dp=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return recur(books,0);
    }
}