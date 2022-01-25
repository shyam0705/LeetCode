class Solution {
    public boolean validMountainArray(int[] arr) {
        int  n=arr.length;
        int i;
        if(n==1 || n==2)
        {
            return false;
        }
        for(i=1;i<n;i++)
        {
            if(arr[i]==arr[i-1])
            {
                return false;
            }
            if(arr[i]<arr[i-1])
            {
                break;
            }
        }
        if(i==1)
        {
            return false;
        }
        if(i==n)
        {
            return false;
        }
        for(int j=i+1;j<n;j++)
        {
            if(arr[j]>=arr[j-1])
            {
                return false;
            }
        }
        return true;
    }
}