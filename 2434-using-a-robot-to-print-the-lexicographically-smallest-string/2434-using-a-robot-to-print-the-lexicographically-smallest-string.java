class Solution {
    int n;
    // public int findMin(String s,int index)
    // {
    //     int min=index;
    //     for(int i=index;i<n;i++)
    //     {
    //         if(s.charAt(i)<s.charAt(min))
    //         {
    //             min=i;
    //         }
    //     }
    //     return min;
    // }
    public String robotWithString(String s) {
        Stack<Character>st=new Stack<>();
        int i=0;
        StringBuilder ans=new StringBuilder();
        n=s.length();
        
        int[] min=new int[n];
        min[n-1]=n-1;
        for(int j=n-2;j>=0;j--)
        {
            if(s.charAt(j)<=s.charAt(min[j+1]))
            {
                min[j]=j;
            }
            else
            {
                min[j]=min[j+1];
            }
        }
        while(i<n)
        {
            int index=min[i];
            while(!st.isEmpty() && st.peek()<=s.charAt(index))
            {
                ans.append(st.pop());
            }
            for(int j=i;j<index;j++)
            {
                st.push(s.charAt(j));
            }
            ans.append(s.charAt(index));
            i=index+1;
        }
        
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        return ans.toString();
    }
}