class Solution {
   
    public boolean isSafe(int n,int row,int col,char[][] board)
    {
        for(int j=0;j<row;j++)
        {
            if(board[j][col]=='Q')
                return false;
        }
        int l=row-1;
        int r=col-1;
        while(l>=0 && r>=0)
        {
            if(board[l][r]=='Q')
                return false;
            l--;
            r--;
        }
        l=row-1;
        r=col+1;
        while(l>=0 && r<n)
        {
            if(board[l][r]=='Q')
                return false;
            l--;
            r++;
        }
        return true;
    }
    
    public int solve(int n,int r,char[][] board)
    {
        if(r==n)
            return 1;
        int count=0;
        for(int c=0;c<n;c++)
        {
            if(isSafe(n,r,c,board))
            {
                board[r][c]='Q';
                count=count+solve(n,r+1,board);
                board[r][c]='.';
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        return solve(n,0,board);
        
    }
}