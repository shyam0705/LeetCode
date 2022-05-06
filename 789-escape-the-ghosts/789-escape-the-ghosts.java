class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int n=ghosts.length;
        int dis=Math.abs(target[1])+Math.abs(target[0]);
        for(int i=0;i<n;i++)
        {
           int tmp=Math.abs(target[1]-ghosts[i][1])+Math.abs(target[0]-ghosts[i][0]);
            if(tmp<=dis)
            {
                return false;
            }
        }
        return true;
    }
}