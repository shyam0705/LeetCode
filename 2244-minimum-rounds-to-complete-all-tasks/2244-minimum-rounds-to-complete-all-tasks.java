class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int count=0;
        int n=tasks.length;
        for(int i=0;i<n;i++)
        {
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }
        for(Integer key:mp.keySet())
        {
            if(mp.get(key)<2)
            {
                return -1;
            }
            if(mp.get(key)%3==0)
            {
                count=count+mp.get(key)/3;
            }
            else if(mp.get(key)%3==2)
            {
                count=count+mp.get(key)/3+1;
            }
            else
            {
                count=count+(mp.get(key)/3)-1+2;
            }
        }
        return count;
    }
}