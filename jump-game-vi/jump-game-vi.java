class Solution {
    public class Pair{
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return b.x-a.x;
        });
        int n=nums.length;
        pq.add(new Pair(nums[0],0));
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            while((i-pq.peek().y)>k)
            {
                pq.remove();
            }
            dp[i]=nums[i]+pq.peek().x;
            pq.add(new Pair(dp[i],i));
        }
        return dp[n-1];
    }
}