class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int binaryDigits = 0;
        long mod=1000000007;
        for (int i = 1; i <= n; i++) {

            if ((i & (i - 1)) == 0) {
                binaryDigits++;
            }

            ans = ((ans << binaryDigits) + i) % mod;
        }
        return (int) ans;
    }
}