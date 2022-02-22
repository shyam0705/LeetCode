class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long left_sum=0;
        long right_sum=0;
        int n=beans.length;
        for(int i=n-1;i>=0;i--)
        {
            right_sum=right_sum+(long)beans[i];
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            long tmp=left_sum+(right_sum-(long)(n-i)*(long)beans[i]);
            ans=Math.min(tmp,ans);
            left_sum=left_sum+beans[i];
            right_sum=right_sum-beans[i];
        }
        return ans;
    }
}