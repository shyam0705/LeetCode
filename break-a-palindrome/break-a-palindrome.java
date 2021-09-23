class Solution {
    public String breakPalindrome(String palindrome) {
        
        String ans="";
        int n=palindrome.length();
        if(n==1)
        {
            return "";
        }
        for(int i=0;i<n/2;i++)
        {
            if(palindrome.charAt(i)!='a')
            {
                ans=ans+palindrome.substring(0,i)+'a'+palindrome.substring(i+1);
                break;
            }
        }
        if(ans.length()==0)
        {
            ans=ans+palindrome.substring(0,n-1)+'b';
        }
        return ans;
    }
}