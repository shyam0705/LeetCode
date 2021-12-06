class Solution {
    public int minCostToMoveChips(int[] position) {
        int n=position.length;
        int odd=0;
        int even=0;
        for(int i=0;i<n;i++)
        {
            if(position[i]%2==0)
            {
                even++;
            }
            else
            {
                odd++;
            }
        }
        return Math.min(odd,even);
    }
}