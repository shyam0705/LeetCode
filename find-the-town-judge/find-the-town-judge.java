class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in=new int[n];
        int[] out=new int[n];
        int m=trust.length;
        for(int i=0;i<m;i++)
        {
            in[trust[i][1]-1]++;
            out[trust[i][0]-1]++;
        }
        for(int i=0;i<n;i++)
        {
            if(in[i]==(n-1) && out[i]==0)
            {
                return i+1;
            }
        }
        return -1;
    }
}