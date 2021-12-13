class Solution {
    public int maxPower(String s) {
        HashSet<Character>hs=new HashSet<>();
        int n=s.length();
        int j=0;
        int ans=0;
        while(j<n)
        {
           int tmp=1;
            int i=j+1;
            while(i<n && s.charAt(j)==s.charAt(i))
            {
                i++;
                tmp++;
            }
            ans=Math.max(ans,tmp);
            j=i;
        }
        return ans;
    }
}