class Solution {
    public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs,(a,b)->{
                return ((a[0]+b[1])-(a[1]+b[0]));
            });
            int c=0;
            int n=costs.length;
            for(int i=0;i<n;i++)
            {
                if(i<n/2)
                {
                    c=c+costs[i][0];
                }
                else
                {
                    c=c+costs[i][1];
                }
            }
            return c;
    }
}