class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int i=-1;
        int k=n;
        int j=0;
        while(j<k)
        {
            if(nums[j]==0)
            {
                i++;
                nums[j]=nums[i];
                nums[i]=0;
                j++;
            }
            else if(nums[j]==2)
            {
                k--;
                nums[j]=nums[k];
                nums[k]=2;
            }
            else
            {
                j++;
            }
        }
        
    }
}