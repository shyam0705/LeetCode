class Solution {
    
    public String repeatLimitedString(String s, int k) {
        int n=s.length();
       int[] arr=new int[26];
        int count=0;
        StringBuilder ans=new StringBuilder();
        int last=-1;
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=25;j>=0;j--)
            {
                if(arr[j]>0)
                {
                    if(last==j)
                    {
                        if(count<k)
                        {
                            ans.append((char)(j+'a'));
                            count++;
                            arr[j]--;
                            break;
                        }
                    }
                    else
                    {
                        ans.append((char)(j+'a'));
                        last=j;
                        count=1;
                        arr[j]--;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }
}