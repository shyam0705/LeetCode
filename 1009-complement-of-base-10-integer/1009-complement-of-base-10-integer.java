class Solution {
    public int bitwiseComplement(int n) {
        int index=-1;
        for(int i=31;i>=0;i--)
        {
            int tmp=(n>>i)&1;
            if(tmp==1)
            {
                index=i+1;
                break;
            }
        }
        if(index==-1)
        {
            return 1;
        }
        return n^((1<<index)-1);
    }
}