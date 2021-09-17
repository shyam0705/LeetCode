class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int minr=0;
        int minc=0;
        int maxr=n-1;
        int maxc=m-1;
        List<Integer>ans=new ArrayList<>();
        int total=n*m;
        int count=0;
        while(count<total)
        {
            //top wall
            for(int i=minc;i<=maxc && count<total;i++)
            {
                count++;
                ans.add(matrix[minr][i]);
            }
            minr++;
            //right wall
            for(int i=minr;i<=maxr && count<total;i++)
            {
                count++;
                ans.add(matrix[i][maxc]);
            }
            maxc--;
            //bottom wall
            for(int i=maxc;i>=minc && count<total;i--)
            {
                count++;
                ans.add(matrix[maxr][i]);
            }
            maxr--;
            for(int i=maxr;i>=minr && count<total;i--)
            {
                count++;
                ans.add(matrix[i][minc]);
            }
            minc++;
        }
        return ans;
    }
}