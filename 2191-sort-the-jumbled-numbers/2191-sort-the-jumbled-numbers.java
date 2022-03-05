class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer>tmp=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            tmp.add(nums[i]);
        }
        Collections.sort(tmp,(n1,n2)->{
            int t1=0;
            int a=n1;
            int b=n2;
             int pow=1;
            if(a==0)
            {
                t1=mapping[0];
            }
           
            else
            {
                 while(a>0)
                {
                    int t=a%10;
                    t1=t1+mapping[t]*pow;
                    pow=pow*10;
                    a=a/10;
                }
            }
          
            int t2=0;
            pow=1;
            if(b==0)
            {
                t2=mapping[0];
            }
            
            else
            {
                 while(b>0)
                {
                    int t=b%10;
                    t2=t2+pow*mapping[t];
                    pow=pow*10;
                    b=b/10;
                }
            }        
            return t1-t2;
        });
        for(int i=0;i<tmp.size();i++)
        {
            nums[i]=tmp.get(i);
        }
        return nums;
    }
}