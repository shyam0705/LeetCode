class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>s=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                s.push(arr[i]);
            }
            else
            {
                while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(arr[i]))
                {
                    s.pop();
                }
                if(s.isEmpty())
                {
                    s.push(arr[i]);
                }
                else if(s.peek()==Math.abs(arr[i]))
                {
                    s.pop();
                }
                else if(s.peek()<0)
                {
                    s.push(arr[i]);
                }
            }
        }
        int[] ans=new int[s.size()];
        int m=s.size();
        int i=s.size()-1;
        while(!s.isEmpty())
        {
            ans[i]=s.pop();
            i--;
        }
        return ans;
        
    }
}