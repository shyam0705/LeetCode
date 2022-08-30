class Solution {
    public int numberOfSubstrings(String s) {
        int a=0;
        int b=0;
        int c=0;
        int n=s.length();
        int i=0;
        int j=0;
        int count=0;
        while(j<n)
        {
            char ch=s.charAt(j);
            switch(ch)
            {
                case 'a':
                    a++;
                    break;
                case 'b':
                    b++;
                    break;
                case 'c':
                    c++;
                    break;
            }
            while(a!=0 && b!=0 && c!=0)
            {
                count=count+n-j;
                char tmp=s.charAt(i);
                switch(tmp)
                {
                    case 'a':
                        a--;
                        break;
                    case 'b':
                        b--;
                        break;
                    case 'c':
                        c--;
                        break;
                }
                i++;
            }
            j++;
        }
        return count;
    }
}