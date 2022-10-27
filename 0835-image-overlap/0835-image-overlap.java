class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int ans=Integer.MIN_VALUE;
        for(int i=-n;i<n;i++)
        {
            for(int j=-n;j<n;j++)
            {
                int sum=0;
                for(int k=0;k<n;k++)
                {
                    for(int l=0;l<n;l++)
                    {
                        int num=k-i>=0 && l-j>=0 && k-i<n && l-j<n?img1[k-i][l-j]:0;
                        if(img2[k][l]==1 && num==1)
                        {
                            sum++;
                        }
                    }
                }
                ans=Math.max(sum,ans);
            }
        }
        
        return ans;
    }
}