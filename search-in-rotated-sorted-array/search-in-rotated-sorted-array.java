class Solution {
    public int search(int[] arr, int key) {
        int l=0;
        int r=arr.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            if(arr[mid]>arr[r])
            {
                if(key<=arr[mid] && key>=arr[l])
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            else
            {
                if(key>=arr[mid] && key<=arr[r])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}