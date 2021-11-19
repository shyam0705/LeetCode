class Solution {
    public int hammingDistance(int x, int y) {
        int diff=0;
        for(int i=0;i<32;i++)
        {
            int tmp1=x & 1;
            int tmp2=y & 1;
            x=x>>1;
            y=y>>1;
            // System.out.println(tmp1+" "+tmp2);
            diff=diff+(tmp1^tmp2);
        }
        return diff;
    }
}