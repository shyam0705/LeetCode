class Solution {
    
    public String diff(String s)
    {
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        for(int i=1;i<n;i++)
        {
            ans.append(s.charAt(i)-s.charAt(i-1));
            ans.append("$");
        }
        return ans.toString();
    }
    public String oddString(String[] words) {
        int n=words.length;
        HashMap<String,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String s=diff(words[i]);
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            String s=diff(words[i]);
            if(mp.get(s)==1)
            {
                return words[i];
            }
        }
        return "";
    }
}