class Solution {
    public boolean checkIfPangram(String sentence) {
        int n=sentence.length();
        int[] arr=new int[26];
        
        for(int i=0;i<n;i++)
        {
            arr[sentence.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(arr[i]==0)
            {
                return false;
            }
        }
        return true;
    }
}