class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int current=startFuel;
        int n=stations.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(current>=stations[i][0])
            {
                pq.add(stations[i][1]);
            }
            else
            {
                while(!pq.isEmpty() && current<stations[i][0])
                {
                    current=current+pq.remove();
                    count++;
                }
                if(current<stations[i][0])
                    return -1;
                pq.add(stations[i][1]);
            }
        }
        while(!pq.isEmpty() && current<target)
        {
            current=current+pq.remove();
            count++;
        }
        return current>=target?count:-1;
        
    }
}