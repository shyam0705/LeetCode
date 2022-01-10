class Solution {
    public String addBinary(String a, String b) {
        int n=a.length();
        int m=b.length();
        int i=n-1;
        int j=m-1;
        int c=0;
        String ans="";
        while(i>=0 || j>=0)
        {
            int tmp1=i>=0?Character.getNumericValue(a.charAt(i)):0;
            int tmp2=j>=0?Character.getNumericValue(b.charAt(j)):0;
            int tmp=(tmp1+tmp2+c)%2;
            c=(tmp1+tmp2+c)/2;
            ans=ans+(char)(tmp+'0');
            i--;
            j--;
        }
        if(c>0)
        {
            ans=ans+(char)(c+'0');
        }
        String t="";
        for(i=ans.length()-1;i>=0;i--)
        {
            t=t+ans.charAt(i);
        }
        return t;
    }
}