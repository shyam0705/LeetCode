class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int i = 0, j = tokens.length-1;
        
        int ans = 0;
        int main=0;
        while(i <= j){
            main=Math.max(main,ans);
            if(power >= tokens[i]){
                ans++;
                power -= tokens[i];
                i++;
            }
            else{
                if(ans>0)
                {
                    ans--;
                    power += tokens[j];
                    j--;
                }
                else
                {
                    break;
                }
               
                
            }
        }
       ans=Math.max(ans,main);
        return ans < 0 ? 0: ans;
    }
}