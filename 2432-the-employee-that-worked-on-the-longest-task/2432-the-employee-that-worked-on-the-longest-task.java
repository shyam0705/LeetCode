class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int start=0;
        int max_index=logs[0][0];
        int max=logs[0][1];
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i][1]-start>=max)
            {

                if(logs[i][1]-start==max)
                    max_index=Math.min(max_index,logs[i][0]);
                else
                    max_index=logs[i][0];
                max=logs[i][1]-start;
            }
            start=logs[i][1];
        }
        return max_index;
    }
}