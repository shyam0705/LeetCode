class Solution {
    int ans;
    int n;
    public void recur(int current,int[] cookies,int[] arr,int k)
    {
        if(current==n)
        {
            int max=arr[0];
            for(int i=1;i<k;i++)
            {
                max=Math.max(max,arr[i]);
            }
            ans=Math.min(ans,max);
            return;
        }
        for(int i=0;i<k;i++)
        {
            arr[i]+=cookies[current];
            recur(current+1,cookies,arr,k);
            arr[i]-=cookies[current];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        n=cookies.length;
        int[] arr=new int[k];
        ans=Integer.MAX_VALUE;
        recur(0,cookies,arr,k);
        return ans;
    }
}