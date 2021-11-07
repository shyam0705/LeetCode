class Solution {
    String res;
    public void add(String num1,String num2)
    {
        int n=num1.length();
        int m=num2.length();
       
        int i=n-1;
        int j=m-1;
        int c=0;
        String ans="";
        while(i>=0 || j>=0)
        {
            int tmp1=i>=0?num1.charAt(i)-'0':0;
            int tmp2=j>=0?num2.charAt(j)-'0':0;
            int tmp=(tmp1+tmp2)+c;
            int d=tmp%10;
            c=tmp/10;
            ans=Integer.toString(d)+ans;
            i--;
            j--;
        }
        if(c>0)
        {
            ans=Integer.toString(c)+ans;
        }
        res=ans;
    }
    public String multiply(String num1, String num2) {
        res="";
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0')
        {
            return "0";
        }
        int n=num1.length();
        int m=num2.length();
        int i=n-1;
        while(i>=0)
        {
            String ans="";
            int c=0;
            int j=m-1;  
            while(j>=0)
            {
                int tmp1=num1.charAt(i)-'0';
                int tmp2=num2.charAt(j)-'0';
                int tmp=(tmp1*tmp2)+c;
                int d=tmp%10;
                c=tmp/10;
                ans=Integer.toString(d)+ans;
                j--;
            }
            if(c>0)
            {
                ans=Integer.toString(c)+ans;
            }
            for(int k=i;k<(n-1);k++)
            {
                ans=ans+"0";
            }
            // System.out.println(ans);
            add(res,ans);
            i--;
        }
        return res;
    }
}