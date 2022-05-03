class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int n=arr.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        dp2[n-1]=arr[n-1];
        dp1[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            dp1[i]=Math.max(dp1[i-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            dp2[i]=Math.min(dp2[i+1],arr[i]);
        }
        int i=0;
        while(i<n && dp1[i]<=arr[i] && dp2[i]>=arr[i])
        {
            i++;
        }
        int j=n-1;
        while(j>=0 && dp1[j]<=arr[j] && dp2[j]>=arr[j])
        {
            j--;
        }
        return Math.max(j-i+1,0);
    }
}