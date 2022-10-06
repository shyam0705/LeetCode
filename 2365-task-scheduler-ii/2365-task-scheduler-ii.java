class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long count=0;
        HashMap<Integer,Long>mp=new HashMap<>();
        int n=tasks.length;
        for(int i=0;i<n;i++)
        {
            count++;
            if(mp.containsKey(tasks[i]))
            {
                long last=mp.get(tasks[i]);
                if(last+space<count)
                {
                    mp.put(tasks[i],count);
                }
                else
                {
                    count=count+last+(long)space-count+1;
                    mp.put(tasks[i],count);
                }
            }
            else
            {
                
                mp.put(tasks[i],count);
            }
        }
        return count;
    }
}