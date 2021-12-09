class Solution {
    boolean[] visited;
    public boolean recur(int[] arr,int i,int n)
    {
    
        if(i<0 || i>=n || visited[i])
        {
            return false;
        }
        if(arr[i]==0)
        {
            return true;
        }
        visited[i]=true;
        boolean ans=recur(arr,i+arr[i],n) || recur(arr,i-arr[i],n);
        visited[i]=false;
        return ans;
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        visited=new boolean[n];
        return recur(arr,start,n);
    }
}