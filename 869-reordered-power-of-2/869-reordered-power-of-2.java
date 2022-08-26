class Solution {
      
    public boolean reorderedPowerOf2(int n) {
        HashSet<Integer>hs=new HashSet<>();
        for(int i=1;i<=1000000000;i=i*2)
        {
            hs.add(i);
        }
        for(Integer el:hs)
        {
            if(match(el,n))
            {
                return true;
            }
        }
        return false;
    }
    public boolean match(int el,int n)
    {
        int[] tmp=new int[10];
        while(el>0)
        {
            tmp[el%10]++;
            el=el/10;
        }
        while(n>0)
        {
            tmp[n%10]--;
            n=n/10;
        }
        for(int i=0;i<=9;i++)
        {
            if(tmp[i]!=0)
                return false;
        }
        return true;
    }
}