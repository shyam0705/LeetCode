class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer>mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int n=s.length();
        int sum=0;
        int i=0;
        while(i<n)
        {
            if(i!=n-1 && mp.get(s.charAt(i))<mp.get(s.charAt(i+1)))
            {
                sum=sum+mp.get(s.charAt(i+1))-mp.get(s.charAt(i));
                i=i+2;
            }
            else
            {
                sum=sum+mp.get(s.charAt(i));
                i++;
            }
        }
        return sum;
    }
}