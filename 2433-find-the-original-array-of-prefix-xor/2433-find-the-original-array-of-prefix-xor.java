class Solution {
    public int[] findArray(int[] pref) {
        
        int n=pref.length;
        int[] ans=new int[n];
        ans[0]=pref[0];
        int current=ans[0];
        for(int i=1;i<n;i++)
        {
            ans[i]=current^pref[i];
            current=current^ans[i];
        }
        return ans;
    }
}