class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[] tmp1={1,0,0,-1,1,-1,-1,1};
        int[] tmp2={0,1,-1,0,1,-1,1,-1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                if(board[i][j]==0)
                {
                    int count=0;
                    for(int k=0;k<8;k++)
                    {
                        int x=i+tmp1[k];
                        int y=j+tmp2[k];
                        
                        if(x>=0 && y>=0 && x<n && y<m && ((board[x][y]==1) || (board[x][y]==-1)))
                        {
                            count++;
                        }
                      
                    }
                      if(count==3)
                        {
                            board[i][j]=-2;
                        }
                }
                else
                {
                     int count=0;
                for(int k=0;k<8;k++)
                    {
                        int x=i+tmp1[k];
                        int y=j+tmp2[k];
                       
                        if(x>=0 && y>=0 && x<n && y<m && ((board[x][y]==1) || (board[x][y]==-1)))
                        {
                            count++;
                        }
                        
                    }
                    if(count<2 || count>3)
                        {
                            board[i][j]=-1;
                        }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==-1)
                {
                    board[i][j]=0;
                }
                if(board[i][j]==-2)
                {
                    board[i][j]=1;
                }
            }
        }
    }
}