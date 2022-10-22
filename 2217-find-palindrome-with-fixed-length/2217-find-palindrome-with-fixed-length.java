class Solution {
    public StringBuilder recur(int length,int current,long k)
    {
        if(current==length-1)
        {
            if(k>10)
            {
                StringBuilder s=new StringBuilder();
                s.append("-1");
                return s;
            }
            else
            {
                
                StringBuilder s=new StringBuilder();
                if(length==1)
                {
                    if(k<=9)
                        s.append(k);
                    else
                        s.append("-1");
                }
                else
                    s.append(k-1);
                return s;
            }
        }
        if(current==0)
        {
            for(int i=1;i<=9;i++)
            {
                long remaining=(long)Math.pow(10,length-current-1)*(long)i;
                if(remaining>=k)
                {
                    StringBuilder tmp=recur(length,current+1,k-(long)Math.pow(10,length-current-1)*(long)(i-1));
                    if(tmp.toString().equals("-1"))
                    {
                        return tmp;
                    }
                    tmp.insert(0,i);
                    return tmp;
                }
            }
        }
        else
        {
            for(int i=0;i<=9;i++)
            {
                 long remaining=(long)Math.pow(10,length-current-1)*(long)(i+1);
                if(remaining>=k)
                {
                    StringBuilder tmp=recur(length,current+1,k-(long)Math.pow(10,length-current-1)*(long)(i));
                    if(tmp.toString().equals("-1"))
                    {
                        return tmp;
                    }
                    tmp.insert(0,i);
                    return tmp;
                }
            }
        }
        StringBuilder t=new StringBuilder();
        t.append("-1");
        return t;
    }
    public long[] kthPalindrome(int[] queries, int intLength) {
        int m=queries.length;
        long[] ans=new long[m];
        int n=(intLength+1)/2;
        for(int i=0;i<m;i++)
        {
            StringBuilder tmp=recur(n,0,(long)queries[i]);
            // System.out.print(tmp);
            if(tmp.toString().equals("-1"))
            {
                // System.out.print("hello");
            }
            else if(intLength%2==0)
            {
                // System.out.println(tmp);
                 StringBuilder a=new StringBuilder(tmp);
                tmp.append(a.reverse());
            }
            else
            {
                tmp.append(new StringBuilder(tmp.substring(0,tmp.length()-1)).reverse());
            }
            ans[i]=Long.parseLong(tmp.toString());
        }
        return ans;
    }
}