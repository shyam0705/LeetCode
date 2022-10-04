class Solution {
    public int calXor(int[] arr,int n)
    {
        int xor=0;
        for(int i=0;i<n;i++)
        {
            xor=xor^arr[i];
        }
        return xor;
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int xor1=0;
        int xor2=0;
        if(n1%2==0 && n2%2==0)
            return 0;
        if(n1%2==0)
        {
           return calXor(nums1,n1);
        }
        else if(n2%2==0)
        {
            return calXor(nums2,n2);
        }
        else
        {
            return calXor(nums1,n1)^calXor(nums2,n2);
        }
    }
}