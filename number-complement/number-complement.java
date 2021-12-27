class Solution {
    public int findComplement(int num) {
        int index=-1;
        for(int i=31;i>=0;i--)
        {
            int tmp=1 & (num>>i);
            if(tmp==1)
            {
                index=i+1;
                break;
            }
        }
        // System.out.println(index);
        int n=(1<<(index))-1;
        // System.out.println(n);
        return num^n;
        
    }
}