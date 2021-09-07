class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                    
                    int l=i+1;
                    int r=j-1;
                    while(l<r)
                    {
                        int product1=nums[i]*nums[j];
                        int product2=nums[l]*nums[r];
                        if(product1==product2)
                        {
                            count++;
                            l++;
                            r--;
                        }
                        else if(product1>product2)
                        {
                            l++;
                        }
                        else
                        {
                            r--;
                        }
                    }
                   
            }
        }
        return 8*count;
    }
}