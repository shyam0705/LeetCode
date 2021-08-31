class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            double dist1=Math.sqrt(b[0]*b[0]+b[1]*b[1]);
            double dist2=Math.sqrt(a[0]*a[0]+a[1]*a[1]);
            if(dist1>dist2)
            {
                return 1;
            }
            else 
            {
                return -1;
            }
        });
        int[][] ans=new int[k][2];
        for(int i=0;i<n;i++)
        {
            pq.add(points[i]);
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        int index=0;
        while(!pq.isEmpty())
        {
            ans[index]=pq.remove();
            index++;
        }
        return ans;
    }
}