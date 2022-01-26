class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int source_r=startPos[0];
        int des_r=homePos[0];
        int source_c=startPos[1];
        int des_c=homePos[1];
        int total=0;
        if(source_r>des_r)
        {
            for(int i=source_r-1;i>=des_r;i--)
            {
                total=total+rowCosts[i];
            }
        }
        else
        {
            for(int i=source_r+1;i<=des_r;i++)
            {
                total=total+rowCosts[i];
            }
        }
        if(source_c>des_c)
        {
            for(int i=source_c-1;i>=des_c;i--)
            {
                total=total+colCosts[i];
            }
        }
        else
        {
            for(int i=source_c+1;i<=des_c;i++)
            {
                total=total+colCosts[i];
            }
        }
        return total;
    }
}