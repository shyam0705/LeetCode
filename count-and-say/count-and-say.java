class Solution {
    public String countAndSay(int n) {
        String current="1";
        for(int k=2;k<=n;k++)
        {
            String tmp="";
            int m=current.length();
            int i=0;
            int j=0;
            while(j<m)
            {
                int count=0;
                while(j<m && current.charAt(i)==current.charAt(j))
                {
                    j++;
                    count++;
                }
                tmp=tmp+count+current.charAt(i);
                i=j;
            }
            System.out.println(tmp);
            current=tmp;
        }
        return current;
    }
}