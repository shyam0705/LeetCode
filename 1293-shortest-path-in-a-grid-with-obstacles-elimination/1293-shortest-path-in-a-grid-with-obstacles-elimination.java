class Solution {
    
    int n;
    int m;
    
    class Node{
        int x;
        int y;
        int k;
        Node(int x,int y,int k)
        {
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(0,0,k));
        
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,1,-1};
        int count=0;
        
        boolean[][][] visited=new boolean[n][m][k+1];
        visited[0][0][k]=true;
        while(!q.isEmpty())
        {
            int len=q.size();
            
            for(int i=0;i<len;i++)
            {
                Node tmp=q.remove();
                if(tmp.x==n-1 && tmp.y==m-1)
                {
                    return count;
                }
                for(int l=0;l<4;l++)
                {
                    int x_new=tmp.x+arr1[l];
                    int y_new=tmp.y+arr2[l];
                    if(x_new>=0 && y_new>=0 && x_new<n && y_new<m)
                    {
                        if(grid[x_new][y_new]==1)
                        {
                            if(tmp.k>0 && !visited[x_new][y_new][tmp.k-1])
                            {
                                visited[x_new][y_new][tmp.k-1]=true;
                                q.add(new Node(x_new,y_new,tmp.k-1));
                            }
                        }
                        else
                        {
                            
                            if(!visited[x_new][y_new][tmp.k])
                            {
                                visited[x_new][y_new][tmp.k]=true;
                                q.add(new Node(x_new,y_new,tmp.k));
                            }
                            
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}