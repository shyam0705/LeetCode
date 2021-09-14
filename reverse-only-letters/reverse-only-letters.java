class Solution {
    public String reverseOnlyLetters(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        int i=0;
        int j=n-1;
        while(i<j)
        {
            if(!(((arr[i]-'a')>=0 && (arr[i]-'a')<26) || ((arr[i]-'A')>=0 && (arr[i]-'A')<26)))
            {
                i++;
            }
            else if(!(((arr[j]-'a')>=0 && (arr[j]-'a')<26) || ((arr[j]-'A')>=0 && (arr[j]-'A')<26)))
            {
                j--;
            }
            else
            {
                //System.out.println("hello");
                char tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                i++;
                j--;
            }
        }
        String ans="";
        for(int k=0;k<n;k++)
        {
            ans=ans+arr[k];
        }
        return ans;
    }
}