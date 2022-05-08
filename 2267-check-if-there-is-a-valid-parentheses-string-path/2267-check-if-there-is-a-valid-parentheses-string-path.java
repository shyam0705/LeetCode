class Solution {
    int n,m;
    HashMap<String,Boolean>mp;
    public boolean recur(char[][] grid,int i,int j,int count)
    {
        
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        if(i==n-1 && j==m-1)
        {
            if(grid[i][j]==')' && count==1)
                return true;
            return false;
        }
        String s=i+"$"+j+"$"+count;
        if(mp.containsKey(s))
        {
            return mp.get(s);
        }
        if(grid[i][j]=='(')
            count++;
        else
            count--;
        if(count<0 || count>(n*m)/2)
        {
            mp.put(s,false);
            return false;
        }
            
        boolean tmp=recur(grid,i+1,j,count) || recur(grid,i,j+1,count);
        mp.put(s,tmp);
        return tmp;
    }
    public boolean hasValidPath(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        mp=new HashMap<>();
        return recur(grid,0,0,0);
    }
}