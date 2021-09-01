class Solution {
    public int dfs(int index,int[] nums,boolean[] visited)
    {
        visited[index]=true;
        int count=1;
        if(visited[nums[index]])
        {
            return count;
        }
        return 1+dfs(nums[index],nums,visited);
    }
    public int arrayNesting(int[] nums) {
        int ans=1;
        int n=nums.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                ans=Math.max(ans,dfs(i,nums,visited));
            }
        }
        return ans;
    }
}