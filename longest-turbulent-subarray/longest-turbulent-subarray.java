class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        int max_prev=1;
        int max=1;
        int max_prev2=1;
        for(int i=n-2;i>=0;i--)
        {
            if(i%2==0)
            {
                if(arr[i]<arr[i+1])
                {
                   max_prev+=1;
                   max_prev2=1; 
                }
                else if(arr[i]==arr[i+1])
                {
                    max_prev=1;
                    max_prev2=1;
                }
                else
                {
                    max_prev=1;
                    max_prev2+=1; 
                }
            }
            else
            {
                if(arr[i]>arr[i+1])
                {
                   max_prev+=1;
                   max_prev2=1; 
                }
                else if(arr[i]==arr[i+1])
                {
                    max_prev=1;
                    max_prev2=1;
                }
                else
                {
                    max_prev=1;
                    max_prev2+=1; 
                }
            }
            max=Math.max(max,Math.max(max_prev,max_prev2));
        }
        return max;
    }
}