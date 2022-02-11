class Solution {
    public boolean check(int[] f1,int[] f2)
    {
        for(int i=0;i<26;i++)
        {
            if(f1[i]!=f2[i])
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m)
        {
            return false;
        }
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(int i=0;i<n;i++)
        {
            f1[s1.charAt(i)-'a']++;
            f2[s2.charAt(i)-'a']++;
        }
        for(int i=n;i<=m;i++)
        {
            if(check(f1,f2))
            {
                return true;
            }
            f2[s2.charAt(i-n)-'a']--;
            if(i!=m)
            {
                 f2[s2.charAt(i)-'a']++;
            }
           
        }
        return false;
    }
}