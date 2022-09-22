class Solution {
    public String reverse(String s)
    {
        StringBuilder st=new StringBuilder(s);
        return st.reverse().toString();
    }
    public String reverseWords(String s) {
        
        String[] arr=s.split(" ");
        int n=arr.length;
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=reverse(arr[i]);
        }
        String ans="";
        for(int i=0;i<arr.length;i++)
        {
            ans=ans+" "+arr[i];
        }
        return ans.trim();
    }
}