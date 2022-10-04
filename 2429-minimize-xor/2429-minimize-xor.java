class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] arr=new int[32];
        int count=0;
        for(int i=0;i<32;i++)
        {
           
            int last_bit_2=(num2>>i)&1;
            if(last_bit_2==1)
            {
                count++;
            }
        }
        for(int i=31;i>=0;i--)
        {
            int last_bit_1=(num1>>i)&1;
            if(count>0 && last_bit_1==1)
            {
                arr[i]=1;
                count--;
            }
        }
        for(int i=0;i<32;i++)
        {
            if(arr[i]==0 && count>0)
            {
                arr[i]=1;
                count--;
            }
        }
        int tmp=0;
        for(int i=0;i<32;i++)
        {
            if(arr[i]==1)
               tmp=tmp+(1<<i);
        }
        return tmp;
    }
}