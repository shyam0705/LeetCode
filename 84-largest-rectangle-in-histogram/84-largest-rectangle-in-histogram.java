class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>s1=new Stack<Integer>();
        Stack<Integer>s2=new Stack<Integer>();
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        s1.push(0);
        dp1[0]=-1;
        dp2[n-1]=n;
        s2.push(n-1);
        for(int i=1;i<n;i++)
        {
            while(!s1.isEmpty() && heights[s1.peek()]>=heights[i])
            {
                s1.pop();
            }
            if(s1.isEmpty())
            {
                dp1[i]=-1;
            }
            else
            {
                dp1[i]=s1.peek();
            }
            s1.push(i);
        }
        for(int i=n-2;i>=0;i--)
        {
            while(!s2.isEmpty() && heights[s2.peek()]>=heights[i])
            {
                s2.pop();
            }
            if(s2.isEmpty())
            {
                dp2[i]=n;
            }
            else
            {
                dp2[i]=s2.peek();
            }
            s2.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,(dp2[i]-dp1[i]-1)*heights[i]);
        }
        return ans;
    }
}