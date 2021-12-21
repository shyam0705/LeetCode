class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int ans=0;
        HashSet<Character>hs=new HashSet<>();
        int n=s.length();
        while(j<n)
        {
           if(hs.contains(s.charAt(j)))
           {
               while(s.charAt(i)!=s.charAt(j))
               {
                   hs.remove(s.charAt(i));
                   i++;
               }
               i++;
           }
            else
            {
                hs.add(s.charAt(j));
            }
           ans=Math.max(ans,j-i+1);
           j++;
        }
        return ans;
    }
}