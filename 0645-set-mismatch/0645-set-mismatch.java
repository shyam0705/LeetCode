class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        long sum=0;
        long square_sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+nums[i];
            square_sum=square_sum+(long)(nums[i])*(long)(nums[i]);
        }
      
    
         long sum_orignal=(long)n*(long)(n+1)/2;
        long square_sum_orignal=((long)(n)*(n+1)*(2*n+1))/6;
        
        long missing_minus_duplicate=sum_orignal-sum;
        long missing_plus_duplicate=(square_sum_orignal-square_sum)/missing_minus_duplicate;
        
        long missing=(missing_minus_duplicate+missing_plus_duplicate)/2;
        long repeat=missing-missing_minus_duplicate;
        
        int[] ans={(int)repeat,(int)missing};
        return ans;
    }
}