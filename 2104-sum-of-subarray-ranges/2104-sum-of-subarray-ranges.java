class Solution {
    public long subArrayRanges(int[] arr) {
        int n=arr.length;
        long[] dp1=new long[n];
        long[] dp2=new long[n];
        long mod=1000000007;
        Stack<Integer>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        s1.add(0);
        s2.add(0);
        long ans=0;
        dp1[0]=arr[0];
        dp2[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            while(!s1.isEmpty() && arr[s1.peek()]>arr[i])
            {
                s1.pop();
            }
            while(!s2.isEmpty() && arr[s2.peek()]<arr[i])
            {
                s2.pop();
            }
            if(s1.isEmpty())
            {
                dp1[i]=((long)(i+1)*(long)arr[i]);
            }
            else
            {
                dp1[i]=(dp1[s1.peek()]+((long)(i-s1.peek())*(long)arr[i]));
            }
            if(s2.isEmpty())
            {
                dp2[i]=((long)(i+1)*(long)arr[i]);
            }
            else
            {
                dp2[i]=(dp2[s2.peek()]+((long)(i-s2.peek())*(long)arr[i]));
            }
            s1.push(i);
            s2.push(i);
            ans=(ans+dp2[i]-dp1[i]);
        }
        return ans;
    }
}