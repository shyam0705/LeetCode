class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        int[] arr=new int[26];
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        for(int j=0;j<n;j++)
        {
            if(arr[s.charAt(j)-'a']==1)
                return j;
        }
        return -1;
    }
}