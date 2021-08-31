class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
       int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int total=((i+1)*(n-i)+1)/2;
            sum=sum+(total)*arr[i];
        }
        return sum;
    }
}