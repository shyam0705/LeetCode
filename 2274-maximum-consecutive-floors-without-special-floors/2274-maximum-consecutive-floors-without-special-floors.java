class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n=special.length;
        int max=special[0]-bottom;
        for(int i=1;i<n;i++)
        {
            max=Math.max(max,special[i]-special[i-1]-1);
        }
        max=Math.max(max,top-special[n-1]);
        return max;
    }
}