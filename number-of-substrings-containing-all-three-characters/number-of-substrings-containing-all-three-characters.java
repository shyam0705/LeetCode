class Solution {
    public int numberOfSubstrings(String s) {
        int count1=0;
        int count2=0;
        int count3=0;
        int count=0;
        int n=s.length();
        int i=0;
        int j=0;
        int ans=0;
        while(j<n)
        {
            while(j<n && count!=3)
            {
                if(s.charAt(j)=='a')
                {
                    count1++;
                    if(count1==1)
                    {
                        count++;
                    }
                }
                else if(s.charAt(j)=='b')
                {
                    count2++;
                    if(count2==1)
                    {
                        count++;
                    }
                }
                else
                {
                    count3++;
                    if(count3==1)
                    {
                        count++;
                    }
                }
                j++;
            }
            while(i<n && count==3)
            {
                ans=ans+n-j+1;
                if(s.charAt(i)=='a')
                {
                    count1--;
                    if(count1==0)
                    {
                        count--;
                    }
                }
                else if(s.charAt(i)=='b')
                {
                    count2--;
                    if(count2==0)
                    {
                        count--;
                    }
                }
                else
                {
                    count3--;
                    if(count3==0)
                    {
                        count--;
                    }  
                }
                i++;
            }
        }
        return ans;
    }
}