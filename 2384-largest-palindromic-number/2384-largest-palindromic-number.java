class Solution {
    public String largestPalindromic(String num) {
        int[] f=new int[10];
        for(char c:num.toCharArray())
        {
            f[c-'0']++;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=9;i>=0;i--)
        {
            int times=f[i]/2;
            for(int j=0;j<times;j++)
            {
                if(ans.length()>0 || i>0)
                    ans.append(i);
            }
        }
        boolean check=false;
        for(int i=9;i>=0;i--){
            if(f[i]%2!=0)
            {
                ans.append(i);
                check=true;
                break;
            }
        }
        if(ans.length()==0)
        {
            return "0";
        }
        if(check)
        {
            StringBuilder tmp=new StringBuilder(ans.substring(0,ans.length()-1));
            ans.append(tmp.reverse());
            return ans.toString();
        }
        else
        {
            StringBuilder tmp=new StringBuilder(ans.substring(0,ans.length()));
            ans.append(tmp.reverse());
            return ans.toString();
        }
    }
}