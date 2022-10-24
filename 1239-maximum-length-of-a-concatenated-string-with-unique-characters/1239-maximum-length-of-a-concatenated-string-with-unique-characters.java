class Solution {
    
    int n;
    public int recur(int[] freq,int index,List<String>arr)
    {
        if(index==n)
        {
            return 0;
        }
        
        String s=arr.get(index);
        int tmp1=recur(freq,index+1,arr);
        
        boolean check=true;
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
            if(freq[s.charAt(i)-'a']>1)
            {
                check=false;
            }
        }
        int tmp2=0;
        if(check)
        {
            tmp2=s.length()+recur(freq,index+1,arr);
        }
        for(int i=0;i<s.length();i++)
        {
             freq[s.charAt(i)-'a']--;
        }
        return Math.max(tmp1,tmp2);
    }
    public int maxLength(List<String> arr) {
        int l=0;
        n=arr.size();
        int[] freq=new int[26];
        return recur(freq,0,arr);
    }
}