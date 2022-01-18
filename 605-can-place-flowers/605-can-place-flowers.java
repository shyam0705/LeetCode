class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int m=arr.length;
        for(int i=0;i<m;i++)
        {
            if(arr[i]==0 && ((i==0 || arr[i-1]==0)&&( i==m-1 || arr[i+1]==0)))
            {
                arr[i]=1;
                n--;
            }
        }
        if(n<=0)
        {
            return true;
        }
        return false;
    }
}