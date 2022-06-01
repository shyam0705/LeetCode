class Solution {
    public int minimumLines(int[][] arr) {
        int n=arr.length;
        if(n==1)
            return 0;
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        int count=1;
        for(int i=2;i<n;i++)
        {
            long tmp1=(long)(arr[i-1][1]-arr[i-2][1])*(long)(arr[i][0]-arr[i-1][0]);
            long tmp2=(long)(arr[i][1]-arr[i-1][1])*(long)(arr[i-1][0]-arr[i-2][0]);
            if(tmp1!=tmp2)
            {
                count++;
            }
        }
        return count;
    }
}