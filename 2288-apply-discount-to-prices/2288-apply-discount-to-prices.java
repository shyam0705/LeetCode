class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words=sentence.split(" ");
        int n=words.length;
        String ans="";
        for(int i=0;i<n;i++)
        {
            
            String s=words[i];
            int m=s.length();
            if(s.charAt(0)!='$' || m==1)
            {
                ans=ans+s+" ";
            }
            else
            {
            
                    int j=1;
                    while(j<m)
                    {
                        if((s.charAt(j)-'0')>=0 && (s.charAt(j)-'0')<=9)
                        {
                            j++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if(j==m)
                    {
                        double d = Double.parseDouble(s.substring(1));
                        double dis=d*(double)discount/(double)100;
                        DecimalFormat decim = new DecimalFormat("0.00");
                        String price=decim.format(d-dis);
                        ans=ans+"$"+price+" ";
                    }
                    else
                    {
                        ans=ans+s+" ";
                    }
                    
                
            }
        }
        return ans.trim();
    }
}