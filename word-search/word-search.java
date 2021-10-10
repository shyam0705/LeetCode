class Solution {
    int n,m;
    public boolean dfs(int i,int j,int index,char[][] board,String word,boolean[][] visited)
    {
        if(index>=word.length()-1)
        {
            return true;
        }
        visited[i][j]=true;
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,-1,1};
        for(int k=0;k<4;k++)
        {
            int x=i+arr1[k];
            int y=j+arr2[k];
            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && board[x][y]==word.charAt(index+1))
            {
                if(dfs(x,y,index+1,board,word,visited))
                {
                    return true;
                }
            }
        }
        visited[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(i,j,0,board,word,visited))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}