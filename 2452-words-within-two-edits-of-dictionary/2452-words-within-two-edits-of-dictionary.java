class Solution {
    public boolean possible(String s1,String s2)
    {
        
        int n=s1.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
          if(s1.charAt(i)!=s2.charAt(i))
          {
              count++;
          }
        }
      
        return count<=2;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary)     {
        List<String>ans=new ArrayList<>();
        for(String s1:queries)
        {
            for(String s2:dictionary)
            {
                if(possible(s1,s2))
                {
                    ans.add(s1);
                    break;
                }
            }
        }
        return ans;
    }
}