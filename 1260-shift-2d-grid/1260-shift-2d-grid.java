class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        
        List<List<Integer>>ans=new ArrayList<>();
        for(int l=0;l<k;l++)
        {
            int tmp=grid[n-1][m-1];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    int tmp1=grid[i][j];
                    grid[i][j]=tmp;
                    tmp=tmp1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            List<Integer>tmp_list=new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                tmp_list.add(grid[i][j]);
            }
            ans.add(tmp_list);
        }
       
        return ans;
    }
}