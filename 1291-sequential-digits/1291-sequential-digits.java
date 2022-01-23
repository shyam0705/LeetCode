class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>ans=new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            for(int j=1;j<=10-i;j++)
            {
                int tmp=j;
                int count=0;
                for(int k=1;k<=i;k++)
                {
                    count=count*10+tmp;
                    tmp++;
                }
                if(count>=low && count<=high)
                {
                    ans.add(count);
                }
            }
        }
        return ans;
    }
}