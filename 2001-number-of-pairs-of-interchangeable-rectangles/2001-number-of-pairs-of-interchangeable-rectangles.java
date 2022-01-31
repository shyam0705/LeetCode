class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Long>mp=new HashMap<>();
        int n=rectangles.length;
        for(int i=0;i<n;i++)
        {
            double tmp=(double)rectangles[i][0]/(double)rectangles[i][1];
            mp.put(tmp,mp.getOrDefault(tmp,(long)0)+(long)1);
        }
        long ans=0;
        for(Long v:mp.values())
        {
            if(v>1)
            {
                ans=ans+((v)*(v-1))/2;
            }
        }
        return ans;
    }
}