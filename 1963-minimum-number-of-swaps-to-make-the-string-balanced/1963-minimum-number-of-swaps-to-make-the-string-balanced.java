class Solution {
    public int minSwaps(String s) {
        int n=s.length();
        int open=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c=='[')
            {
                open++;
            }
            else
            {
                if(open==0)
                {
                    open++;
                    ans++;
                }
                else
                {
                    open--;
                }
            }
        }
        return ans;
    }
}