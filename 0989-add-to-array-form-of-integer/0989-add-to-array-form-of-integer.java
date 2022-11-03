class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer>ans=new ArrayList<>();
        int n=num.length;
        int i=n-1;
        int rem=0;
        while(i>=0 && k>0)
        {
            
            int digit=(num[i]+(k%10)+rem)%10;
            rem=(num[i]+(k%10)+rem)/10;
            
            ans.add(digit);
            i--;
            k=k/10;
        }
        
        while(i>=0)
        {
            int digit=(num[i]+rem)%10;
            rem=(num[i]+rem)/10;
            ans.add(digit);
            i--;
        }
        
        while(k>0)
        {
            int digit=((k%10)+rem)%10;
            rem=((k%10)+rem)/10;
            ans.add(digit);
            k=k/10;
        }
        
        if(rem>0)
        {
            ans.add(rem);
        }
        Collections.reverse(ans);
        return ans;
    }
}