class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length;
        HashMap<String,Integer>mp=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            String s=words[i];
            String rev=s.charAt(1)+""+s.charAt(0);
            if(mp.containsKey(rev))
            {
                
                count+=4;
                if(mp.get(rev)==1)
                {
                    mp.remove(rev);
                }
                else
                {
                    mp.put(rev,mp.get(rev)-1);
                }
            }
            else
            {
                mp.put(s,mp.getOrDefault(s,0)+1);
            }
        }
        for(int i=0;i<n;i++)
        {
            String s=words[i];
            if(s.charAt(0)==s.charAt(1) && mp.containsKey(s))
            {
                count+=2;
                break;
            }
        }
        return count;
    }
}