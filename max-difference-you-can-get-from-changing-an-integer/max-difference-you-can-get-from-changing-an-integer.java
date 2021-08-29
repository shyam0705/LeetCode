class Solution {
    public int maxDiff(int num) {
        String s=Integer.toString(num);
        int n=s.length();
        char tmp='a';
        boolean hasChanged=false;
        String high="";
        for(int i=0;i<s.length();i++)
        {
            if(hasChanged)
            {
                if(s.charAt(i)==tmp)
                {
                    high=high+'9';
                }
                else
                {
                    high=high+s.charAt(i);
                }
            }
            else
            {
                if(s.charAt(i)!='9')
                {
                    hasChanged=true;
                    tmp=s.charAt(i);
                }
                high=high+'9';
            }
        }
        tmp='a';
        hasChanged=false;
        String low="";
        if(s.charAt(0)!='1')
        {
            low=low+'1';
            tmp=s.charAt(0);
            for(int i=1;i<n;i++)
            {
                if(s.charAt(i)==tmp)
                {
                    low=low+'1';
                }
                else
                {
                    low=low+s.charAt(i);
                }
            }
        }
        else
        {
            low=low+'1';
            for(int i=1;i<s.length();i++)
            {
                if(s.charAt(i)=='1')
                {
                    low=low+'1';
                    continue;
                }
                if(hasChanged)
                {
                    if(s.charAt(i)==tmp)
                    {
                        low=low+'0';
                    }
                    else
                    {
                        low=low+s.charAt(i);
                    }
                }
                else
                {
                    if(s.charAt(i)!='0')
                    {
                        hasChanged=true;
                        tmp=s.charAt(i);
                    }
                    low=low+'0';
                }
            }
        }
        System.out.println(high);
        System.out.println(low);
        return Integer.parseInt(high)-Integer.parseInt(low);
    }
}