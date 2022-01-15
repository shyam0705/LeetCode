class Solution {
    boolean[] visited;
    int n;
    HashMap<Integer,ArrayList<Integer>>mp;
    public int minJumps(int[] arr) {
        
        mp=new HashMap<>();
        n=arr.length;
        visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            mp.putIfAbsent(arr[i],new ArrayList<>());
            mp.get(arr[i]).add(i);
          
        }
        Queue<Integer>q=new LinkedList<>();
        int count=0;
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int m=q.size();
            for(int i=0;i<m;i++)
            {
                int tmp=q.remove();
                if(tmp==n-1)
                {
                    return count;
                }
                if((tmp+1)<n && !visited[tmp+1])
                {
                    visited[tmp+1]=true;
                    q.add(tmp+1);
                }
                if((tmp-1)>=0 && !visited[tmp-1])
                {
                    visited[tmp-1]=true;
                    q.add(tmp-1);
                }
                if(mp.containsKey(arr[tmp]))
                {
                    for(Integer el:mp.get(arr[tmp]))
                    {
                        if(!visited[el])
                        {
                            visited[el]=true;
                            q.add(el);
                        }
                    }
                    mp.remove(arr[tmp]);
                }
              
            }
            count++;
        }
        return count;
    }
}