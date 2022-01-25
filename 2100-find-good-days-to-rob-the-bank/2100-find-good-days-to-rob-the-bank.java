class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        int n=arr.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        dp1[0]=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]<=arr[i-1])
            {
                dp1[i]=dp1[i-1]+1;
            }
            else
            {
                dp1[i]=1;
            }
        }
        dp2[n-1]=1;
        for(int j=n-2;j>=0;j--)
        {
            if(arr[j]<=arr[j+1])
            {
                dp2[j]=dp2[j+1]+1;
            }
            else
            {
                dp2[j]=1;
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(dp1[i]>time && dp2[i]>time) 
            {
                ans.add(i);
            }
        }
        return ans;
    }
}