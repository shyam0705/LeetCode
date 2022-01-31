class Solution {
    public boolean checkMove(char[][] board, int r, int c, char color) {
        int n=board.length;
        int m=board[0].length;
        if(board[r][c]!='.')
            return false;
        boolean nextValid=false;
        boolean sameColor=false;
        for(int i=r+1;i<n;i++)
        {
            if(board[i][c]=='.')
                break;
            if(i==r+1)
            {
                if(board[i][c]!=color)
                {
                    nextValid=true;
                }
                else
                    break;
            }
            if(board[i][c]==color)   
            {
                sameColor=true;
                break;
            }
        }
        if(sameColor && nextValid)
        {
            return true;
        }
        nextValid=false;
        sameColor=false;
        for(int i=r-1;i>=0;i--)
        {
            if(board[i][c]=='.')
                break;
            if(i==r-1)
            {
                if(board[i][c]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[i][c]==color)   
            {
                sameColor=true;
                break;
            }
        }
        if(sameColor && nextValid)
        {
            return true;
        }
        nextValid=false;
        sameColor=false;
        for(int i=c+1;i<m;i++)
        {
            if(board[r][i]=='.')
                break;
            if(i==c+1)
            {
                if(board[r][i]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[r][i]==color)   
            {
                sameColor=true;
                break;
            }
        }
        if(sameColor && nextValid)
        {
            return true;
        }
        nextValid=false;
        sameColor=false;
        for(int i=c-1;i>=0;i--)
        {
            if(board[r][i]=='.')
                break;
            if(i==c-1)
            {
                if(board[r][i]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[r][i]==color)   
            {
                sameColor=true;
                break;
            }
        }
        if(sameColor && nextValid)
        {
            return true;
        }
        nextValid=false;
        sameColor=false;
        int l=r-1;
        int h=c-1;
        while(l>=0 && h>=0)
        {
            if(board[l][h]=='.')
                break;
            if(l==r-1 && h==c-1)
            {
                if(board[l][h]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[l][h]==color)   
            {
                sameColor=true;
                break;
            }
            l--;
            h--;
        }
        if(sameColor && nextValid)
        {
            return true;
        }
        nextValid=false;
        sameColor=false;
        l=r+1;
        h=c+1;
        while(l<n && h<m)
        {
            if(board[l][h]=='.')
                break;
            if(l==r+1 && h==c+1)
            {
                if(board[l][h]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[l][h]==color)   
            {
                sameColor=true;
                break;
            }
            l++;
            h++;
        }
        if(sameColor && nextValid)
        {
            return true;
        } 
        nextValid=false;
        sameColor=false;
        l=r-1;
        h=c+1;
        while(l>=0 && h<m)
        {
            if(board[l][h]=='.')
                break;
            if(l==r-1 && h==c+1)
            {
                if(board[l][h]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[l][h]==color)   
            {
                sameColor=true;
                break;
            }
            l--;
            h++;
        }
        if(sameColor && nextValid)
        {
            return true;
        } 
        nextValid=false;
        sameColor=false;
        l=r+1;
        h=c-1;
        while(l<n && h>=0)
        {
            if(board[l][h]=='.')
                break;
            if(l==r+1 && h==c-1)
            {
                if(board[l][h]!=color)
                {
                    nextValid=true;
                }
            }
            if(board[l][h]==color)   
            {
                sameColor=true;
                break;
            }
            l++;
            h--;
        }
        if(sameColor && nextValid)
        {
            return true;
        } 
        return false;
    }
}