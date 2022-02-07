class Solution {
    public char findTheDifference(String s, String t) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+(t.charAt(i)-s.charAt(i));
        }
        sum=sum+(t.charAt(n)-'a');
        return (char)(sum+'a');
    }
}