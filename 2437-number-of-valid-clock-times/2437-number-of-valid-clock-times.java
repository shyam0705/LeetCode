class Solution {
    public int countTime(String time) {
        int total=1;
        int i=0;
        int n=time.length();
        while(i<n)
        {
            if(time.charAt(i)=='?')
            {
                switch(i)
                {
                    case 0:
                        if(time.charAt(1)=='?')
                            total=total*24;
                        else if(time.charAt(1)-'0'<=3)
                            total=total*3;
                        else
                            total=total*2;
                        i=i+2;
                        break;
                    case 1:
                        if(time.charAt(0)=='2')
                            total=total*4;
                        else
                            total=total*10;
                        i=i+2;
                        break;
                    case 3:
                        total=total*6;
                        i++;
                        break;
                    case 4:
                        total=total*10;
                        i++;
                        break;
                    default:
                        i++;
                
                }
            }
            else
            {
                i++;
            }
        }
        return total;
    }
}