class Solution {
    int n;
    // public long recur(int[] nums,int index,int index_in_sub,int n)
    // {
    //     if(index==n)
    //     {
    //         return 0;
    //     }
    //     long tmp1=recur(nums,index+1,index_in_sub+1,n);
    //     long tmp2=recur(nums,index+1,index_in_sub,n);
    //     if(index_in_sub%2==0)
    //     {
    //         tmp1+=(long)nums[index];
    //     }
    //     else
    //     {
    //         tmp1-=(long)nums[index];
    //     }
    //     return Math.max(tmp1,tmp2);
    // }
    public long maxAlternatingSum(int[] nums) {
        n=nums.length;
        long odd=nums[0];
        long even=0;
        for(int i=0;i<n;i++)
        {
            odd=Math.max(Math.max(odd,even+(long)nums[i]),(long)nums[i]);
            even=Math.max(even,odd-(long)nums[i]);
        }
        return Math.max(odd,even);
    }
}