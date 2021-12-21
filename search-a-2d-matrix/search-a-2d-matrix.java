class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int r=n*m-1;
        
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            int r_mid=mid/m;
            int  c_mid=mid%m;   
            if(matrix[r_mid][c_mid]==target)
            {
                return true;
            }
            else if(matrix[r_mid][c_mid]>target)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
                
        }
        return false;
    }
}