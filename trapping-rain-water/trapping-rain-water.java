class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int max_index=0;
        for(int i=1;i<n;i++)
        {
            if(height[i]>height[max_index])
            {
                max_index=i;
            }
        }
        int left_max=height[0];
        int right_max=height[max_index];
        int sum=0;
        for(int i=1;i<max_index;i++)
        {
            if(height[i]<left_max)
            {
                sum=sum+(left_max-height[i]);
            }
            else
            {
                left_max=height[i];
            }
        }
        left_max=height[max_index];
        right_max=height[n-1];
        for(int i=n-2;i>max_index;i--)
        {
            if(height[i]<right_max)
            {
                sum=sum+(right_max-height[i]);
            }
            else
            {
                right_max=height[i];
            }
        }
        return sum;
    }
}