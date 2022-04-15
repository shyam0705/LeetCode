class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans=0;
        long countA=0;
        long countB=0;
        for(char c:text.toCharArray())
        {
            if(c==pattern.charAt(1))
            {
                countB++;
                ans=ans+countA;
            }
            if(c==pattern.charAt(0))
            {
                countA++;
            }
        }
        return Math.max(ans+countA,ans+countB);
    }
}