class Solution {
    List<List<String>>ans;
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
    public void recur(int n,int r,char[][] board)
    {
        if(r==n)
        {
            List<String>tmp=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String tmp_string="";
                for(int j=0;j<n;j++)
                {
                    tmp_string=tmp_string+board[i][j];
                }
                tmp.add(tmp_string);
            }
            ans.add(tmp);
        }
        else
        {
             for(int c=0;c<n;c++)
             {
                if(isSafe(n,r,c,board))
                {
                    board[r][c]='Q';
                    recur(n,r+1,board);
                    board[r][c]='.';
                }
            }
        }
       
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        ans=new ArrayList<>();
        recur(n,0,board);
        return ans;
    }
}