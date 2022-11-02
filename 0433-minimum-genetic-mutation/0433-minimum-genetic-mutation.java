class Solution {
    HashSet<String>hs;
    public int recur(StringBuilder s,StringBuilder end)
    {
        if(s.toString().equals(end.toString()))
        {
            return 0;
        }

        int ans=Integer.MAX_VALUE;
        char[] arr={'A','C','G','T','A'};
        for(int i=0;i<8;i++)
        {
            for(char c:arr)
            {
                char tmp=s.charAt(i);
                s.setCharAt(i,c);
                String tmp_s=s.toString();
                if(hs.contains(tmp_s))
                {
                    hs.remove(tmp_s);
                    int tmp_ans=recur(s,end);
                    if(tmp_ans!=-1)
                    {
                        ans=Math.min(ans,1+tmp_ans);
                    }
                    hs.add(tmp_s);
                }
                s.setCharAt(i,tmp);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int minMutation(String start, String end, String[] bank) {
        hs=new HashSet<>();
        for(String s:bank)
        {
            hs.add(s);
        }
        
        return recur(new StringBuilder(start),new StringBuilder(end));
    }
}