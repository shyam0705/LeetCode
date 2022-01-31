class Solution {
    public int[] findOriginalArray(int[] changed) {
        int m=changed.length;
        int n=m/2;
        int[] ans=new int[n];
        HashMap<Integer,Integer>mp=new HashMap<>();
        Arrays.sort(changed);
        int j=0;
        for(int i=0;i<m;i++)
        {
            if(changed[i]%2==0 && mp.containsKey(changed[i]/2))
            {
                int tmp=mp.get(changed[i]/2);
                if(tmp-1==0)
                {
                    mp.remove(changed[i]/2);
                }
                else
                {
                    mp.put(changed[i]/2,tmp-1);
                }
            }
            else
            {
                if(j<n)
                {
                    ans[j]=changed[i];
                    j++;
                   mp.put(changed[i],mp.getOrDefault(changed[i],0)+1);
                }
                else
                {
                    return new int[0];
                }
               
            }
        }
        return ans;
    }
}