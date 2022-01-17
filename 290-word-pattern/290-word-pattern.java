class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        int n=arr.length;
        int m=pattern.length();
        
        if(n!=m)
        {
            return false;
        }
        HashMap<Character,String>mp=new HashMap<>();
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(pattern.charAt(i)))
            {
                String v=mp.get(pattern.charAt(i));
                if(!v.equals(arr[i]))
                {
                    return false;
                }
            }
            else
            {
                if(hs.contains(arr[i]))
                {
                    return false;
                }
                mp.put(pattern.charAt(i),arr[i]);
                hs.add(arr[i]);
            }
            
        }
        return true;
    }
}