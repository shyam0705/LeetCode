class Solution {
    public boolean isSet(int num,int index)
    {
        int tmp=(num&(1<<index));
        if(tmp>0)
        {
            return true;
        }
        return false;
    }
    public int[] singleNumber(int[] nums) {
        int xor=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            xor=xor^nums[i];
        }
         // System.out.println(xor);
        int index=32;
        for(int i=0;i<32;i++)
        {
            // System.out.println(i);
            if(isSet(xor,i))
            {
               index=i;
               break;
            }
        }
        // System.out.println(index);
        int[] ans=new int[2];
        for(int i=0;i<n;i++)
        {
            if(isSet(nums[i],index))
            {
                ans[0]=ans[0]^nums[i];
            }
        }
        ans[1]=xor^ans[0];
        return ans;
    }
}