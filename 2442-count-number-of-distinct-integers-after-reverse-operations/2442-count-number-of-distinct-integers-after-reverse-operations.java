class Solution {
    public int reverseNum(int n)
    {
        int tmp=0;
        while(n>0)
        {
            tmp=tmp*10+n%10;
            n=n/10;
        }
        return tmp;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            hs.add(num);
            int reverse=reverseNum(num);
            hs.add(reverse);
        }
        return hs.size();
    }
}