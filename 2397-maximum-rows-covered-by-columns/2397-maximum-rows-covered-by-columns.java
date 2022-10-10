class Solution {
    int n;
    public int recur(int[][] matrix,int k,int index,int m,int num)
    {
        if(index==m)
        {
            int count=0;
            for(int i=0;i<n;i++)
            {
                boolean check=true;
                for(int j=0;j<m;j++)
                {
                    if(matrix[i][j]==1 && (((num>>j)&1)!=1))
                    {
                        check=false;
                        break;
                    }
                }
                if(check)
                    count++;
                
            }
            return count;
        }
        int tmp=0;
        if(k>0)
            tmp=recur(matrix,k-1,index+1,m,num+(1<<index));
        
        tmp=Math.max(tmp,recur(matrix,k,index+1,m,num));
        return tmp;
        
        
    }
    public int maximumRows(int[][] matrix, int numSelect) {
        n=matrix.length;
        int m=matrix[0].length;
        return recur(matrix,numSelect,0,m,0);
    }
}