class Solution {
    class Node{
        int x,y,max;
        Node(int x,int y,int max){
            this.x=x;
            this.y=y;
            this.max=max;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[] arr1={0,0,1,-1};
        int[] arr2={-1,1,0,0};
        PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->{
            return a.max-b.max;
        });
        pq.add(new Node(0,0,0));
        boolean[][] visited=new boolean[n][m]; 
        while(!pq.isEmpty())
        {
            Node node=pq.remove();
            visited[node.x][node.y]=true;
            if(node.x==n-1 && node.y==m-1)
            {
                return node.max;
            }
            for(int k=0;k<4;k++)
            {
                int x=node.x+arr1[k];
                int y=node.y+arr2[k];
                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y])
                {
                    pq.add(new Node(x,y,Math.max(node.max,Math.abs(heights[x][y]-heights[node.x][node.y]))));
                }
            }
        }
        return 0;
    }
}