class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                {
                    count++;
                    board[i][j]='.';
                    int x=i;
                    int y=j+1;
                    while(y<m && board[x][y]=='X')
                    {
                        board[x][y]='.';
                        y++;
                    }
                    y=j-1;
                    while(y>=0 && board[x][y]=='X')
                    {
                        board[x][y]='.';
                        y--;
                    }
                    x=i+1;
                    y=j;
                    while(x<n && board[x][y]=='X')
                    {
                        board[x][y]='.';
                        x++;
                    }
                    x=i-1;
                    while(x>=0 && board[x][y]=='X')
                    {
                        board[x][y]='.';
                        x--;
                    }
                    
                }
            }
        }
        return count;
    }
}