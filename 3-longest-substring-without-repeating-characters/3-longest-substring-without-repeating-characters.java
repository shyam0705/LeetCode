class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        HashSet<Character>hs=new HashSet<>();
        int ans=0;
        while(j<n)
        {
            char c=s.charAt(j);
            if(hs.contains(c))
            {
               
                ans=Math.max(ans,j-i);
                while(s.charAt(i)!=c)
                {
                    hs.remove(s.charAt(i));
                    i++;
                }
                i++;
                
            }
            j++;
            hs.add(c);
        }
        // System.out.println(j+" "+i);
        ans=Math.max(ans,j-i);
        return ans;
    }
}