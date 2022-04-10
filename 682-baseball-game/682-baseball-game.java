class Solution {
    public int calPoints(String[] ops) {
      Stack<Integer>s=new Stack<>();
        int n=ops.length;
        for(int i=0;i<n;i++)
        {
            if(ops[i].equals("+"))
            {
                int tmp=s.pop();
                int tmp2=s.pop();
                s.push(tmp2);
                s.push(tmp);
                s.push(tmp+tmp2);
            }
            else if(ops[i].equals("D"))
            {
                s.push(2*s.peek());
            }
            else if(ops[i].equals("C"))
            {
                s.pop();
            }
            else
            {
                s.push(Integer.parseInt(ops[i]));
            }
        }
        int sum=0;
        while(!s.isEmpty())
        {
            sum+=s.pop();
        }
        return sum;
    }
}