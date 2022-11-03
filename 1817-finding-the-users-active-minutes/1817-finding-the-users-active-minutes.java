class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,HashSet<Integer>>mp=new HashMap<>();
        int n=logs.length;
        
        for(int i=0;i<n;i++)
        {
            int id=logs[i][0];
            int t=logs[i][1];
            
            if(mp.containsKey(id))
            {
               mp.get(id).add(t);
            }
            else
            {
                HashSet<Integer>tmp=new HashSet<>();
                tmp.add(t);
                mp.put(id,tmp);
            }
        }
        
        int[] ans=new int[k];
        mp.forEach((e,v)->{
            if(v.size()<=k)
            {
                ans[v.size()-1]++;
            }
        });
        return ans;
    }
}