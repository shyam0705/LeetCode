class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair>q=new LinkedList<>();
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0 || i==n-1 || j==m-1)
                {
                    if(board[i][j]=='O')
                    {
                        q.add(new Pair(i,j));
                        board[i][j]='.';
                    }
                }
            }
        }
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,-1,1};
        while(!q.isEmpty())
        {
           Pair tmp=q.remove();
            for(int k=0;k<4;k++)
            {
                int x=tmp.x+arr1[k];
                int y=tmp.y+arr2[k];
                if(x>=0 && y>=0 && x<n && y<m && board[x][y]=='O')
                {
                    q.add(new Pair(x,y));
                    board[x][y]='.';
                }
           
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='.')
                {
                    board[i][j]='O';
                }
                else
                {
                    board[i][j]='X';
                }
            }
        }
        
    }
}