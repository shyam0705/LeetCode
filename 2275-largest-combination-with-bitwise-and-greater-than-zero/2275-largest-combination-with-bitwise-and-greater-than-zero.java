class Solution {
    public int largestCombination(int[] candidates) {
        int n=candidates.length;
        int[] arr=new int[32];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<32;j++)
            {
                int bit=candidates[i]&1;
               
                if(bit==1)
                {
                    arr[j]++;
                }
                candidates[i]=candidates[i]>>1;
            }
            // System.out.println();
        }
        int max=0;
        for(int i=0;i<32;i++)
        {
            max=Math.max(arr[i],max);
        }
        return max;
    }
}