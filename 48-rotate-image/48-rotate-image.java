class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int i=0;i<n;i++)
        {
            int l=0;
            int r=m-1;
            while(l<r)
            {
                int tmp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=tmp;
                l++;
                r--;
            }
        }
        
    }
}