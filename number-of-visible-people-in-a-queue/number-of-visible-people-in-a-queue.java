class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        Stack<Integer>s=new Stack<>();
        int[] ans=new int[n];
        ans[n-1]=0;
        s.push(heights[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            int count=0;
            Stack<Integer>tmp=new Stack<>();
            while(!s.isEmpty() && s.peek()<heights[i])
            {
                tmp.push(s.pop());
                count++;
            }
            ans[i]=s.isEmpty()?count:count+1;
            while(!tmp.isEmpty())
            {
                s.push(tmp.pop());
            }
            while(!s.isEmpty() && s.peek()<=heights[i])
            {
                s.pop();
            }
            s.push(heights[i]);
        }
        return ans;
    }
}