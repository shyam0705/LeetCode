class Solution {
    public int priority(char c)
    {
        if(c=='+' || c=='-')
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int solve(int u,int v,char c)
    {
        if(c=='+')
        {
            return u+v;
        }
        else if(c=='-')
        {
            return u-v;
        }
        else if(c=='*')
        {
            return u*v;
        }
        else
        {
            return u/v;
        }
    }
    public int calculate(String s) {
        int n=s.length();
        Stack<Integer>operand=new Stack<>();
        Stack<Character>operator=new Stack<>();
        int i=0;
        while(i<n)
        {
            if(s.charAt(i)==' ')
            {
                i++;
            }
            else if(Character.isDigit(s.charAt(i)))
             {
                   int tmp=0;
                   while(i<n && Character.isDigit(s.charAt(i)))
                   {
                       tmp=tmp*10+(s.charAt(i)-'0');
                       i++;
                   }
                   operand.push(tmp);
            }
            else
             {
                    char op=s.charAt(i);
                    while(!operator.isEmpty() && priority(op)<=priority(operator.peek()))
                    {
                        int v=operand.pop();
                        int u=operand.pop();
                        char c=operator.pop();
                        // System.out.println(u+" "+v+" "+c);
                        operand.push(solve(u,v,c));
                   }
                    operator.push(op);
                 i++;
             }
        }
        while(!operator.isEmpty())
        {
                int v=operand.pop();
                int u=operand.pop();
                char c=operator.pop();
                operand.push(solve(u,v,c));
        }
        return operand.peek();
    }
}