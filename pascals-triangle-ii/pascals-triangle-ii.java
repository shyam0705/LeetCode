class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>ans=new ArrayList<>();
        int r=rowIndex;
        for(int c=0;c<rowIndex+1;c++)
        {
            if(c==0)
            {
                ans.add(1);
            }
            else
            {
                int tmp=ans.get(ans.size()-1);
                long tmpAns=(long)tmp*(long)(r-c+1)/(long)c;
                ans.add((int)tmpAns);
                
            }
        }
        return ans;
    }
}