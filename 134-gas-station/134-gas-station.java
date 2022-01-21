class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr=0;
        int prev=0;
        int n=gas.length;
        int start=0;
        for(int i=0;i<n;i++)
        {
            curr=curr+gas[i]-cost[i];
            if(curr<0)
            {
                start=i+1;
                prev=prev+curr;
                curr=0;
            }
        }
        if(curr>=Math.abs(prev))
        {
            return start;
        }
        return -1;
    }
}