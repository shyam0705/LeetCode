class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k)
        {
             int j=0;
            String ans="";
            int sum=0;
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                if(j==k)
                {
                    ans=ans+sum;
                    j=0;
                    sum=0;
                }
                sum=sum+(s.charAt(i)-'0');
                j++;

            }
            ans=ans+sum;
            s=ans;
        }
        return s;
       
    }
}