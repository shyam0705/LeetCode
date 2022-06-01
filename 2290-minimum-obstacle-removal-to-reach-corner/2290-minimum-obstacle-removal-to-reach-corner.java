class Solution {
    class Node{
        int x,y;
        int cost;
        Node(int x,int y,int cost)
        {
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,1,-1};
        pq.add(new Node(0,0,0));
        boolean[][] visited=new boolean[n][m];
        int[][] dis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        while(!pq.isEmpty())
        {
            Node tmp=pq.remove();
            visited[tmp.x][tmp.y]=true;
            if(tmp.x==n-1 && tmp.y==m-1)
            {
                return tmp.cost;
            }
            for(int k=0;k<4;k++)
            {
                int x=tmp.x+arr1[k];
                int y=tmp.y+arr2[k];
                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && dis[x][y]>(tmp.cost+grid[x][y]))
                {
                    dis[x][y]=tmp.cost+grid[x][y];
                    pq.add(new Node(x,y,tmp.cost+grid[x][y]));
                }
            }
        }
        return -1;
    }
}