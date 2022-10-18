class Solution {
    public String recur(int n)
    {
        if(n==1)
        {
            return "1";
        }
        else
        {
            String tmp=recur(n-1);
            int l=tmp.length();
            StringBuilder ans=new StringBuilder();
            int i=0;
            while(i<l)
            {
                int count=0;
                int j=i;
                while(j<l && tmp.charAt(j)==tmp.charAt(i))
                {
                    j++;
                    count++;
                }
                ans.append(count);
                ans.append(tmp.charAt(i));
                i=j;

                
            }
            return ans.toString();
        }
    }
    public String countAndSay(int n) {
        return recur(n);
    }
}