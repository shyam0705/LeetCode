class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n=A.length;
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                mp.put(A[i]+B[j],mp.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                count=count+mp.getOrDefault(-(C[i]+D[j]),0);
            }
        }
        return count;
        
    }
}