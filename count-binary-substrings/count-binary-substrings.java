class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int current=1;
        int prev=0;
        int ans=0;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                current++;
            }
            else
            {
                prev=current;
                current=1;
            }
            if(prev>=current)
            {
                ans++;
            }
        }
        return ans;
    }
}