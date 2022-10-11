class Solution {
    public int countAsterisks(String s) {
        int ans=0;
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='|')
            {
                count++;
            }
            else if(s.charAt(i)=='*')
            {
                if(count%2==0)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}