class Solution {
    public int recur(HashSet<Integer>current,int i,int n)
    {
       
        if(i==n)
        {
            int count=0;
            //System.out.println("hello");
            for(Integer el:current)
            {
                //System.out.println(current);
                if(el%i==0 || i%el==0)
                {
                    count++;
                }
            }
            return count;
        }
        int count=0;
        for(Integer el:current)
        {
            //System.out.println("hello");
            if(el%i==0 || i%el==0)
            {
                HashSet<Integer>tmp=new HashSet<>(current);
                tmp.remove(el);
                count=count+recur(tmp,i+1,n);
            }
        }
        return count;
    }
    public int countArrangement(int n) {
        HashSet<Integer>hs=new HashSet<>();
        for(int i=1;i<=n;i++)
        {
            hs.add(i);
        }
        return recur(hs,1,n);
    }
}