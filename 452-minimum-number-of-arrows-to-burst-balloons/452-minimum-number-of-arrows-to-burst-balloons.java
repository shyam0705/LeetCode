class Solution {
    public int findMinArrowShots(int[][] points) {
        int count=1;
        int n=points.length;
        Arrays.sort(points,(a,b)->{
            if(a[0]>b[0])
            {
                return 1;
            }
            if(b[0]>a[0])
            {
                return -1;
            }
            return 0;
        });
        int x=points[0][0];
        int y=points[0][1];
        for(int i=1;i<n;i++)
        {
            int tmpx=points[i][0];
            int tmpy=points[i][1];
            if(tmpx>y)
            {
                x=tmpx;
                y=tmpy;
                count++;
            }
            else
            {
                x=tmpx;
                y=Math.min(tmpy,y);
            }
        }
        return count;
        
    }
}