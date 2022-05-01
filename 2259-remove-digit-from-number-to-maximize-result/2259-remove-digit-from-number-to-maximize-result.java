class Solution {
    public String removeDigit(String number, char digit) {
        int n=number.length();
        for(int i=0;i<n;i++)
        {
            if(number.charAt(i)==digit && i!=n-1 && (number.charAt(i+1)-'0')>(number.charAt(i)-'0'))
               {
                   return number.substring(0,i)+number.substring(i+1);
               }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(number.charAt(i)==digit)
            {
                return number.substring(0,i)+number.substring(i+1);
            }
        }
        return number;
    }
}