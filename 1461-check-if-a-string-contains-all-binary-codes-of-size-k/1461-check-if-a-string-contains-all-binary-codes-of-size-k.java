class Solution {
    HashSet<Integer>hs;
    // public void genrate(int k,int tmp)
    // {
    //     if(k==0)
    //     {
    //         hs.add(tmp);
    //         return;
    //     }
    //     genrate(k-1,tmp+(1<<k-1));
    //     genrate(k-1,tmp);
    // }
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        hs=new HashSet<>();
        // genrate(k,0);
        for(int i=0;i<=n-k;i++)
        {
            int j=i;
            int tmp=0;
            while(j<(i+k))
            {
                if(s.charAt(j)=='1')
                {
                    tmp=tmp+(1<<(k-j+i-1));
                }
                j++;
            }
            // System.out.println(tmp);
            // if(hs.contains(tmp))
            // {
            //     hs.remove(tmp);
            // }
            hs.add(tmp);
        }
        long sum=0;
        for(int el:hs)
        {
        
            sum=sum+(long)el;
        }
        long index=(1<<k)-1;
        long tmp=(index)*(index+1)/2;
        return tmp==sum && hs.contains(0);
    }
}