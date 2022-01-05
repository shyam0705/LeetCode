class Solution {
    List<List<String>>ans;
    List<String>current;
    public void recur(String s,int i,int n)
    {
        if(i==n)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int j=i;j<n;j++)
        {
            if(isPal(s,i,j))
            {
                current.add(s.substring(i,j+1));
                recur(s,j+1,n);
                current.remove(current.size()-1);
            }
        }
        
    }
    public boolean isPal(String s,int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        current=new ArrayList<>();
        recur(s,0,s.length());
        return ans;
    }
}