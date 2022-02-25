class Solution {
    public int com(String tmp1,String tmp2)
    {
        if(tmp1.equals(tmp2))
        {
            return 0;
        }
        int n=tmp1.length();
        int m=tmp2.length();
        int i=0;
        int j=0;
        // System.out.println(tmp1+" "+tmp2);
        while(i<n && tmp1.charAt(i)=='0')
        {
            i++;
        }
        while(j<m && tmp2.charAt(j)=='0')
        {
            j++;
        }
        int length1=n-i+1;
        int length2=m-j+1;
        if(length1<length2)
        {
            return -1;
        }
        if(length2<length1)
        {
            return 1;
        }
        while(i<n && j<m)
        {
            if(tmp1.charAt(i)>tmp2.charAt(j))
            {
                return 1;
            }
            else if(tmp1.charAt(i)<tmp2.charAt(j))
            {
                return -1;
            }
            i++;
            j++;
        }
        if(i<n)
            return 1;
        if(j<m)
            return -1;
        return 0;
        
    }
    public int compareVersion(String version1, String version2) {
        String[] arr1=version1.split("\\.");
        String[] arr2=version2.split("\\.");
        int n=arr1.length;
        int m=arr2.length;
        int i=0;
        while(i<n | i<m)
        {
            String tmp1=i<n?arr1[i]:"0";
            String tmp2=i<m?arr2[i]:"0";
            int ans=com(tmp1,tmp2);
            if(ans!=0)
            {
                return ans;
            }
            i++;
        }
        return 0;
    }
}