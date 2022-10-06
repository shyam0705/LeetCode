class Solution {
    public char repeatedCharacter(String s) {
        int n=s.length();
        int[] arr=new int[26];
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            arr[c-'a']++;
            if(arr[c-'a']>1)
            {
                return c;
            }
        }
        return 'a';
    }
}