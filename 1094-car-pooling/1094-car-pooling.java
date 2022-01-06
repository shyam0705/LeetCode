class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        int[] arr=new int[1001];
        for(int i=0;i<n;i++)
        {
            arr[trips[i][1]]=arr[trips[i][1]]+trips[i][0];
            arr[trips[i][2]]=arr[trips[i][2]]-trips[i][0];
        }
        if(arr[0]>capacity)
        {
            return false;
        }
        for(int i=1;i<=1000;i++)
        {
            arr[i]=arr[i-1]+arr[i];
            if(arr[i]>capacity)
            {
                return false;
            }
        }
        return true;
    }
}