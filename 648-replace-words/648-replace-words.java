class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String>hs=new HashSet<>();
        for(String s:dictionary)
        {
            hs.add(s);
        }
        String ans="";
        for(String s:sentence.split(" "))
        {
            int n=s.length();
            String tmp="";
            for(int i=0;i<n;i++)
            {
                tmp=tmp+s.charAt(i);
                if(hs.contains(tmp))
                {
                    break;
                }
            }
            if(ans.equals(""))
            {
                ans=ans+tmp;
            }
            else
                ans=ans+" "+tmp;
        }
        return ans;
    }
}