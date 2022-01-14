class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int n=s.length();
        System.out.println(s);
        if(n==0)
        {
            return 0;
        }
        long ans=0;
        long tmp1=(long)Math.pow(2,31)-1;
        long tmp2=(long)Math.pow(2,31);
        System.out.println(tmp1);
        //  System.out.println(tmp2);
        boolean negative=false;
        if(s.charAt(0)=='-')
        {
           
            negative=true;
        }
      
       
            int i=0;
            if(s.charAt(i)=='+' || s.charAt(i)=='-')
            {
                i++;
            }
            while(i<n && !((s.charAt(i)-'0')>=1 && ((s.charAt(i)-'0')<=9)))
            {
                
                if(!((s.charAt(i)-'0')>=0 && ((s.charAt(i)-'0')<=9)))
                {
                    
                    // System.out.println("hello");
                    return 0;
                }
                i++; 
            }
             // System.out.println(i);
            while((i<n && (s.charAt(i)-'0')>=0 && ((s.charAt(i)-'0')<=9)))
            {
                ans=ans*10+(s.charAt(i)-'0');
                if(!negative && ans>tmp1)
                {
                    ans=tmp1;
                }
                if(negative && ans>tmp2)
                {
                    ans=tmp2;
                }
                i++;
            }
        
        if(negative)
        {
            return -(int)ans;
        }
        return (int)ans;
    }
}