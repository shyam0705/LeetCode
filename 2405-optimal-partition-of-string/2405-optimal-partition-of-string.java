class Solution {
    public int partitionString(String s) {
        int n=s.length();
        int[] arr=new int[26];
        int count=1;
        for(int i=0;i<n;i++)
        {
            int index=s.charAt(i)-'a';
            if(arr[index]!=0)
            {
                count++;
                arr=new int[26];
            }
            arr[index]=1;
        }
        return count;
    }
}