class Solution {
    int n;
    int m;
    boolean[] visited;
    public int dfs(int[][] students,int[][]mentors,int i)
    {
        if(i>=n)
        {
            return 0;
        }
        int ans=0;
        for(int j=0;j<n;j++)
        {
            if(!visited[j])
            {
                visited[j]=true;
                int tmp=cal(students[i],mentors[j])+dfs(students,mentors,i+1);
                ans=Math.max(ans,tmp);
                visited[j]=false;
            }
        }
        return ans;
    }
    public int cal(int[] arr1,int[] arr2)
    {
        int count=0;
        for(int i=0;i<m;i++)
        {
            if(arr1[i]==arr2[i])
            {
                count++;
            }
        }
        return count;
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        n=students.length;
        m=students[0].length;
        visited=new boolean[n];
        int ans=dfs(students,mentors,0);
        return ans;
    }
}