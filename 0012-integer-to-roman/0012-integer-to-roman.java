class Solution {
    public String intToRoman(int num) {

        int[] integer={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};   
        String ans="";
        while(num>0)
        {
            for(int i=12;i>=0;i--)
            {
                if(integer[i]<=num)
                {
                    ans=ans+roman[i];
                    num=num-integer[i];
                    break;
                }
            }
        }
        return ans;
    }
}