class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] tmp=new int[n];
        for(int k=0;k<n;k++)
        {
            tmp[k]=nums[k];
        }
        Arrays.sort(tmp);
        int i=0;
        while(i<n && nums[i]==tmp[i])
        {
            i++;
        }
        int j=n-1;
        while(j>=0 && nums[j]==tmp[j])
        {
            j--;
        }
        if(i>=j)
        {
            return 0;
        }
        return j-i+1;
    }
}