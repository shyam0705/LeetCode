class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]>l=new ArrayList<>();
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        l.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
            int start1=l.get(l.size()-1)[0];
            int end1=l.get(l.size()-1)[1];
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            if(start2>end1)
            {
                l.add(intervals[i]);
            }
            else if(end2<=end1)
            {
                
            }
            else
            {
                int[] tmp=new int[2];
                tmp[0]=start1;
                tmp[1]=end2;
                l.set(l.size()-1,tmp);
            }
        }
        int[][] ans=new int[l.size()][2];
        for(int i=0;i<l.size();i++)
        {
            ans[i]=l.get(i);
        }
        return ans;
        
    }
}