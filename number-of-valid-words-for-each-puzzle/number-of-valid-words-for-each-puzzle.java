class Solution {
    public int getMask(String s,int start)
    {
        int mask=0;
        for(int i=start;i<s.length();i++)
        {
            mask=mask | (1<< (s.charAt(i)-'a'));
        }
        return mask;
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(String s:words)
        {
            int mask=getMask(s,0);
            mp.put(mask,mp.getOrDefault(mask,0)+1);
        }
        List<Integer>ans=new ArrayList<Integer>();
        for(String s:puzzles)
        {
            int mask=getMask(s,1);
            int firstMask=1<<(s.charAt(0)-'a');
            int sub=mask;
            int count=mp.getOrDefault(firstMask,0);
            while(sub!=0)
            {
                if(mp.containsKey(firstMask | sub))
                {
                    count=count+mp.get(firstMask|sub);
                }
                sub=(sub-1) & mask;
            }
            ans.add(count);
        }
        return ans;
    }
}