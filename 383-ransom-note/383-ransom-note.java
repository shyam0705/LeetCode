class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        int n=magazine.length();
        for(int i=0;i<n;i++)
        {
            arr[magazine.charAt(i)-'a']++;
        }
        for(int j=0;j<ransomNote.length();j++)
        {
            int tmp=ransomNote.charAt(j)-'a';
            if(arr[tmp]==0)
                return false;
            arr[tmp]--;
        }
        return true;
    }
}