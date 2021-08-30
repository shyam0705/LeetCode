class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        int c=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum=sum+Math.abs(matrix[i][j]);
                if(matrix[i][j]==0)
                {
                    flag=true;
                }
                if(matrix[i][j]<0)
                {
                    c++;
                }
                min=Math.min(Math.abs(matrix[i][j]),min);
            }
        }
        if(c%2==0 || flag)
        {
            return sum;
        }
        else
        {
            return (sum-2*min);
        }
    }
}