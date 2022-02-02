class Solution {
    public boolean isSame(int[] freq1,int[] freq2)
    {
        
        for(int i=0;i<26;i++)
        {
           if(freq1[i]!=freq2[i])
               return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        int n=s.length();
        int m=p.length();
        if(m>n)
        {
            return new ArrayList<Integer>();
        }
        for(int k=0;k<m;k++)
        {
            freq1[p.charAt(k)-'a']++;
            freq2[s.charAt(k)-'a']++;
        }
        ArrayList<Integer>ans=new ArrayList<>();
       for(int i=m-1;i<n;i++)
       {
           if(isSame(freq1,freq2))
           {
               ans.add(i-m+1);
           }
           freq2[s.charAt(i-m+1)-'a']--;
           if((i+1)<n)
           {
               freq2[s.charAt(i+1)-'a']++;
           }
       }
        return ans;
    }
}