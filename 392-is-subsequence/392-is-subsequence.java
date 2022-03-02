class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        int n=s.length();
        int m=t.length();
        int match=0;
        while(i<n && j<m)
        {
            while(j<m)
            {
                if(s.charAt(i)==t.charAt(j))
                {
                    match++;
                    break;
                }
                
                j++;
            }
            if(j==m)
            {
                return false;
            }
            i++;
            j++;
        }
        return match==n;
    }
}