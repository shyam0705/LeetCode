class Solution {
    
    
    public boolean anagram(String s1,String s2)
    {
        int n=s1.length();
        int m=s2.length();
        
        if(n!=m)
            return false;
        int[] arr1=new int[26];
        for(int i=0;i<n;i++)
        {
            arr1[s1.charAt(i)-'a']++;
            arr1[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(arr1[i]!=0)
                return false;
        }
        
        return true;
    }
    
    public List<String> removeAnagrams(String[] words) {
        List<String>ans=new ArrayList<>();
        int n=words.length;
        ans.add(words[0]);
        for(int i=1;i<n;i++)
        {
            String last=ans.get(ans.size()-1);
            if(!anagram(last,words[i]))
            {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}