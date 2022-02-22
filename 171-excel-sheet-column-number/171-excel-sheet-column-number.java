class Solution {
    public int titleToNumber(String s) {
        int n=s.length();
        int current=1;
        int num=0;
        for(int i=n-1;i>=0;i--)
        {
            num=num+(s.charAt(i)-'A'+1)*current;
            current=current*26;
        }
        return num;
            
    }
}