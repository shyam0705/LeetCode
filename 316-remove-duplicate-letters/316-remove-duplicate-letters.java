class Solution {
    public String recur(String s)
    {
        int n=s.length();
        if(n==0)
        {
            return "";
        }
        int[] arr=new int[26];
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        int pos=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)<s.charAt(pos))
            {
                pos=i;
            }
            arr[s.charAt(i)-'a']--;
            if(arr[s.charAt(i)-'a']==0)
                break;
        }
        return s.charAt(pos)+recur(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
    public String removeDuplicateLetters(String s) {
        return recur(s);
    }
}