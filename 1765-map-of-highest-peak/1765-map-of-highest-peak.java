class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int[][] highestPeak(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] ans=new int[n][m];
        boolean[][] visited=new boolean[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1)
                {
                    ans[i][j]=0;
                    visited[i][j]=true;
                    q.add(new Pair(i,j));
                }
            }
        }
        int[] arr1={1,0,-1,0};
        int[] arr2={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair tmp=q.remove();
            for(int k=0;k<4;k++)
            {
                int x=tmp.x+arr1[k];
                int y=tmp.y+arr2[k];
                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y])
                {
                    ans[x][y]=ans[tmp.x][tmp.y]+1;
                    visited[x][y]=true;
                    q.add(new Pair(x,y));
                }
            }
        }
        return ans;
    }
}