class Time{
    int index;
    int val;
    boolean isStart;
    Time(int x,int y,boolean z)
    {
        index=x;
        val=y;
        isStart=z;
    }
}
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        ArrayList<Time>l=new ArrayList<>();
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            l.add(new Time(i,times[i][0],true));
            l.add(new Time(i,times[i][1],false));
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=1;i<=n;i++)
        {
            pq.add(i);
        }
        Collections.sort(l,(a,b)->{
            if(a.val==b.val)
            {
                if(a.isStart)
                {
                    return 1;
                }
                return -1;
            }
            return a.val-b.val;
        });
        
        for(int i=0;i<l.size();i++)
        {
            Time t=l.get(i);
            if(t.isStart)
            {
                int seat=pq.remove();
                if(t.index==targetFriend)
                {
                    return seat-1;
                }
                mp.put(t.index,seat);
            }
            else
            {
                int index=t.index;
                int seat=mp.get(index);
                pq.add(seat);
                mp.remove(index);
            }
        }
        return -1;
        
        
    }
}