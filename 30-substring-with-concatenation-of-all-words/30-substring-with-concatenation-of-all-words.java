class Solution {
    int n;
    int m;
    public boolean recur(String s,HashMap<String,Integer>mp,int index)
    {
        if(mp.size()==0)
        {
            return true;
        }
        if(index==n)
        {
            return false;
        }
        String current="";
        current=current+s.substring(index,Math.min(n,index+m));
        if(mp.containsKey(current))
        {
                //System.out.println(i+" "+current);
                int tmp=mp.get(current);
                if(tmp==1)
                    mp.remove(current);
                else
                    mp.put(current,tmp-1); 
                boolean check=recur(s,mp,index+m);
                mp.put(current,tmp);
                if(check)
                    return true;
        }
        return false;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>ans=new ArrayList<>();
        HashMap<String,Integer>mp=new HashMap<>();
        n=s.length();
        m=words[0].length();
        for(int i=0;i<words.length;i++)
        {
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        for(int i=0;i<n;i++)
        {
            if(recur(s,mp,i))
            {
                ans.add(i);
            }
        }
        return ans;
    }
}