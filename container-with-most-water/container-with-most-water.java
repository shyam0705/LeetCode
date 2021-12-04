class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0;
        int j=n-1;
        int ans=Integer.MIN_VALUE;
        while(i<=j)
        {
            ans=Math.max(ans,(j-i)*Math.min(height[i],height[j]));
            if(height[i]>height[j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return ans;
    }
}