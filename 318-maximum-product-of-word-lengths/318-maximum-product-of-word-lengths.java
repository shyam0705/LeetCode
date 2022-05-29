class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        HashMap<Integer,HashSet<String>>mp=new HashMap<>();
        for(int ch=0;ch<26;ch++)
        {
            mp.put(ch,new HashSet<>());
        }
        for(int ch=0;ch<26;ch++)
        {
            
            for(int i=0;i<n;i++)
            {
                int m=words[i].length();
                for(char c:words[i].toCharArray())
                {
                    mp.get(c-'a').add(words[i]);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                boolean check=true;
                for(int k=0;k<26;k++)
                {
                    if(mp.get(k).contains(words[i])&& mp.get(k).contains(words[j]))
                    {
                        check=false;
                        break;
                    }
                }
                if(check)
                {
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
       
    }
}