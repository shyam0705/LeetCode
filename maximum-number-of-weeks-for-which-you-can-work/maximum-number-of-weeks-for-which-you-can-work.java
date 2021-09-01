class Solution {
    public long numberOfWeeks(int[] milestones) {
       
        int n=milestones.length;
        long count=0;
        long max=milestones[0];
        long sum=0;

        for(int i=0;i<n;i++)
        {
            max=Math.max(max,milestones[i]);
            sum+=milestones[i];
        }
        long rSum=sum-max;
        count=count+rSum;
        if(rSum>=max)
        {
            count=count+max;
        }
        else
        {
            count=count+rSum+1;
        }
        
        return count;
        
    }
}