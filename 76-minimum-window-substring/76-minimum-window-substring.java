class Solution {
    public String minWindow(String s, String t) {
        int[] arr1=new int[70];
        int[] arr2=new int[70];
        int m=s.length();
        int n=t.length();
        if(n>m)
            return "";
        for(int i=0;i<n;i++)
        {
            arr2[t.charAt(i)-'A']++;
        }
        int count=0;
        for(int i=0;i<70;i++)
        {
            if(arr2[i]>0)
            {
                count++;
            }
        }
        int i=0;
        int j=0;
        int ans=Integer.MAX_VALUE;
        int start=-1;
        int end=-1;
        while(j<m)
        {
            int index=s.charAt(j)-'A';
            // System.out.println(index);
            arr1[index]++;
            if(arr1[index]==arr2[index])
            {
                count--;
            }
            // System.out.println(count);
            while(count==0)
            {
                // System.out.println("Hello");
                int length=j-i+1;
                if(length<ans)
                {
                    ans=length;
                    start=i;
                    end=j;
                }
                if(arr2[s.charAt(i)-'A']==arr1[s.charAt(i)-'A'])
                {
                    count++;
                }
                arr1[s.charAt(i)-'A']--;
                i++;
            }
            j++;
        }
        if(ans==Integer.MAX_VALUE)
            return "";
        return s.substring(start,end+1);
        
    }
}