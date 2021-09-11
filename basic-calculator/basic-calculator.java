class Solution {
    public int eval(int v1,int v2,char code)
    {
        if(code=='+')
        {
            return v1+v2;
        }
        else
        {
            return v1-v2;
        }
    }
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        char[] arr=s.toCharArray();
        int n=arr.length;
        Stack<Integer>s1=new Stack<>();
        Stack<Character>s2=new Stack<>();
        int i=0;
        while(i<n)
        {
            if(arr[i]=='(')
            {
                s2.push(arr[i]);
                i++;
            }
            else if(arr[i]=='+' || arr[i]=='-')
            {
              
                    while(s2.size()>0 && s2.peek()!='(')
                    {
                        int v2=s1.pop();
                        if(s1.isEmpty())
                        {
                            s2.pop();
                            s1.push(-v2);
                        }
                        else
                        {
                            int v1=s1.pop();
                            char code=s2.pop();
                            s1.push(eval(v1,v2,code));
                        }
                    }
                    s2.push(arr[i]);
                    i++;
                
            }
            else if(arr[i]==')')
            {
                while(s2.peek()!='(')
                {
                    int v2=s1.pop();
                    int v1=s1.pop();
                    char code=s2.pop();
                    s1.push(eval(v1,v2,code));
                }
                s2.pop();
                i++;
            }
            else
            {
                int tmp=0;
                while(i<n && Character.isDigit(arr[i]))
                {
                    tmp=tmp*10+(arr[i]-'0');
                    i++;
                }
                s1.push(tmp);
            }
        }
        
        while(!s2.isEmpty())
        {
            int v2=s1.pop();
            if(s1.isEmpty())
            {
                s2.pop();
                s1.push(-v2);
            }
            else
            {
                    int v1=s1.pop();
                    char code=s2.pop();
                    s1.push(eval(v1,v2,code));
            }
        }
        return s1.peek();
            
    }
}