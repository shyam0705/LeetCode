class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        int max_ending=arr[0];
        int max=arr[0];
        int min_ending=arr[0];
        int min=arr[0];
        int sum=arr[0];
        for(int i=1;i<n;i++)
        {
            max_ending=Math.max(arr[i],max_ending+arr[i]);
            max=Math.max(max_ending,max);
            min_ending=Math.min(arr[i],min_ending+arr[i]);
            min=Math.min(min,min_ending);
            sum=sum+arr[i];
        }
        //System.out.println(max+" "+min+" "+sum);
        if(min==sum)
        {
            return max;
        }
        return Math.max(max,sum-min);
    }
}