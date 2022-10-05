class Solution {
    public int longestContinuousSubstring(String s) {
        int n=s.length();
        int i=0;
        int j=1;
        int ans=1;
        while(i<n && j<n)
        {
            int current=s.charAt(j)-'a';
            int last=s.charAt(j-1)-'a';
            if(last==current-1)
            {
                ans=Math.max(ans,j-i+1);
            }
            else
            {
                i=j;
            }
            j++;
        }
        return ans;
    }
}