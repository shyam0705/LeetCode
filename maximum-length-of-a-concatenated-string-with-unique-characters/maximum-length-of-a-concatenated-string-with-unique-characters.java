class Solution {
    int ans;
    boolean[] visited;
    public void recur(List<String>arr,int i,int n,String current)
    {
        if(i==n)
        {
            ans=Math.max(current.length(),ans);
            return;
        }
        boolean canTake=true;
        boolean[] tmp=new boolean[26];
        for(char c:arr.get(i).toCharArray())
        {
            
            if(visited[c-'a'] || tmp[c-'a'])
            {
                canTake=false;
            }
            tmp[c-'a']=true;
        }
        if(canTake)
        {
            for(char c:arr.get(i).toCharArray())
            {
                visited[c-'a']=true;
            }
            recur(arr,i+1,n,current+arr.get(i));
            for(char c:arr.get(i).toCharArray())
            {
                visited[c-'a']=false;
            }
        }
        recur(arr,i+1,n,current);  
    }
    public int maxLength(List<String> arr) {
        ans=0;
        int n=arr.size();
        visited=new boolean[26];
        recur(arr,0,n,"");
        return ans;
    }
}