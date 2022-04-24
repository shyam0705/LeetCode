class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        ArrayList<ArrayList<Integer>>dp=new ArrayList<>();
        Arrays.sort(rectangles,(a,b)->{
            return a[0]-b[0];
        });
        int n=rectangles.length;
        int m=points.length;
        for(int i=0;i<=100;i++)
        {
            dp.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            int h=rectangles[i][1];
            for(int j=0;j<=h;j++)
            {
                dp.get(j).add(rectangles[i][0]);
            }
        }
        int[] ans=new int[m];
        for(int i=0;i<m;i++)
        {
            ArrayList<Integer> l=dp.get(points[i][1]);
            ans[i]=binarySearch(l,points[i][0]);
        }     
        return ans;
    }
    public int binarySearch(ArrayList<Integer>arr,int target)
    {
        int l=0;
        int r=arr.size()-1;
        int ans=arr.size();
       
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr.get(mid)<target)
            {
                l=mid+1;
            }
            else
            {
                ans=mid;
                r=mid-1;
            }
        }
        return arr.size()-ans;
    }
}