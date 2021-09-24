class Solution {
    public int longestValidParentheses(String str) {
        int n=str.length();
        Stack<Integer>index=new Stack<>();
        index.push(-1);
        int i=0;
        int ans=0;
        int count=0;
        for(char c:str.toCharArray())
        {
            if(c=='(')
            {
                index.push(i);
                count++;
                
            }
            else
            {
                
                if(!index.isEmpty() && count>0)
                {
                    index.pop();
                    int tmp=index.peek();
                    ans=Math.max(ans,i-tmp);
                    count--;
                }
                else
                {
                    index.push(i);
                }
            
            }
            i++;
        }
        return ans;
            
                                     
    }
}