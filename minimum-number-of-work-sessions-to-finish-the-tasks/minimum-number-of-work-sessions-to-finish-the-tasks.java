class Solution {
    HashMap<String,Integer>mp;
    public String encode(ArrayList<Integer>arr,int i)
    {
        ArrayList<Integer>session=new ArrayList<>(arr);
        Collections.sort(session);
        String key = Integer.toString(i) + "$";
        for (int j = 0; j < session.size(); j++)
            key += Integer.toString(session.get(j)) + "$";
        
        return key;

    }
   public int recur(int[] tasks,ArrayList<Integer>session,int i,int n,int time)
   {
       if(i>=n)
       {
           return 0;
       }
       String key=encode(session,i);
       if(mp.containsKey(key))
       {
           return mp.get(key);
       }
        session.add(tasks[i]);
       int ans=1+recur(tasks,session,i+1,n,time);
       session.remove(session.size()-1);
       for(int j=0;j<session.size();j++)
       {
           if(session.get(j)+tasks[i]<=time)
           {
               int tmp=session.get(j);
               session.set(j,tmp+tasks[i]);
               ans=Math.min(ans,recur(tasks,session,i+1,n,time));
               session.set(j,tmp);
           }
       }
       mp.put(key,ans);
       return ans;
   }
    public int minSessions(int[] tasks, int sessionTime) {
        mp=new HashMap<>();
        ArrayList<Integer> session=new ArrayList<>();
        return recur(tasks,session,0,tasks.length,sessionTime);
    }
}