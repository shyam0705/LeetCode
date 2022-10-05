class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
        });
        int count=1;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return a-b;
        });
        pq.add(intervals[0][1]);
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]<=pq.peek())
            {
                pq.add(intervals[i][1]);
                count++;
            }
            else
            {
                pq.remove();
                pq.add(intervals[i][1]);
            }
        }
        return count;
    }
}