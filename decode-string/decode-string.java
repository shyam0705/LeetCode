class Solution {
    public String decodeString(String s) {
        int n=s.length();
        String ans="";
        Stack<String>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==']')
            {
                
                int tmp=s2.pop();
                String t="";
                while(!s1.peek().equals("["))
                {
                    t=s1.peek()+t;
                    s1.pop();
                }
                String tmp2="";
                for(int j=0;j<tmp;j++)
                {
                    tmp2=tmp2+t;
                }
                s1.pop();
                s1.push(tmp2);
                
            }
            else if(Character.isDigit(s.charAt(i)))
            {
                String tmp="";
                while(Character.isDigit(s.charAt(i)))
                {
                    tmp=tmp+s.charAt(i);
                    i++;
                }
                i--;
                s2.push(Integer.parseInt(tmp));
            }
            else
            {
                s1.push(s.charAt(i)+"");
            }
            
        }
        while(!s1.isEmpty())
        {
            ans=s1.pop()+ans;
        }
        return ans;
    }
}