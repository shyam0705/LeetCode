class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        int i=n-1;
        String ans="";
        while(i>=0)
        {
            while(i>=0 && s.charAt(i)==' ')
            {
                i--;
            }
            int j=i;
            while(j>=0 && s.charAt(j)!=' ')
            {
                j--;
            }
         
            String tmp=s.substring(j+1,i+1);
            ans=ans+tmp+" ";
            i=j;
        }
        i=ans.length()-1;
        while(i>=0 && ans.charAt(i)==' ')
        {
            i--;
        }
        return ans.substring(0,i+1);
    }
}