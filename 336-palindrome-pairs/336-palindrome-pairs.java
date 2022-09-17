class Solution {
    public boolean isPal(String s1)
    {
       
        int l=0;
        int r=s1.length()-1;
        while(l<=r)
        {
            if(s1.charAt(l)!=s1.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public String reverse(String str){
        StringBuilder sb= new StringBuilder(str);
        return sb.reverse().toString();
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        int n=words.length;
        List<List<Integer>>ans=new ArrayList<>();
        HashMap<String,Integer>mp=new HashMap<>();
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            mp.put(words[i],i);
        }
        for(int i=0;i<n;i++)
        {
            //case 1
            String s=words[i];
            int m=s.length();
            for(int j=0;j<=m;j++)
            {
                String tmp=reverse(s.substring(0,j));
                if(mp.containsKey(tmp) && isPal(s.substring(j)))
                {
                    if(i!=mp.get(tmp) && !hs.contains(i+"$"+mp.get(tmp)))
                    {
                        List<Integer>tmp_l=new ArrayList<>();
                        tmp_l.add(i);
                        tmp_l.add(mp.get(tmp));
                        ans.add(tmp_l);
                        hs.add(i+"$"+mp.get(tmp));
                    }
                    
                }
            }
            
            //case 2
            s=reverse(words[i]);
            m=s.length();
            for(int j=0;j<=m;j++)
            {
                 String tmp=s.substring(0,j);
                if(mp.containsKey(tmp) && isPal(s.substring(j)))
                {
                    if(i!=mp.get(tmp)  && !hs.contains(mp.get(tmp)+"$"+i))
                    {
                        List<Integer>tmp_l=new ArrayList<>();
                        tmp_l.add(mp.get(tmp));
                        tmp_l.add(i);
                        ans.add(tmp_l);
                        hs.add(mp.get(tmp)+"$"+i);
                    }
                    
                }
            }
        }
        return ans;
    }
}