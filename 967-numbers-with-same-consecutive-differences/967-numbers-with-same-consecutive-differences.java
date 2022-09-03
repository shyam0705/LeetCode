class Solution {
    HashSet<Integer>ans;
    public void recur(int i,int n,int k)
    {
        if(n==0)
        {
           ans.add(i); 
           return;
        }
        if(i==0)
        {
            for(int j=1;j<=9;j++)
            {
                recur(j,n-1,k);
            }
        }
        else
        {
            int tmp=i%10;
            if(tmp+k<=9)
            {
                recur(i*10+(tmp+k),n-1,k);
            }
            if(tmp-k>=0)
            {
                recur(i*10+(tmp-k),n-1,k);
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        ans=new HashSet<>();
        recur(0,n,k);
        int[] arr=new int[ans.size()];
        int i=0;
        for(int el:ans)
        {
            arr[i]=el;
            i++;
        }
        return arr;
    }
}