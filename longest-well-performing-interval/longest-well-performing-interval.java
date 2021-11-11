class Solution {
    public int longestWPI(int[] hours) {
        int ans=0;
        int n=hours.length;
        
        HashMap<Integer,Integer>mp=new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(hours[i]>8)
            {
                hours[i]=1;
            }
            else
            {
                hours[i]=-1;
            }
            sum=sum+hours[i];
            if(sum>0)
            {
                ans=i+1;
            }
            if((mp.containsKey(sum-1)))
            {
                
                ans=Math.max(ans,i-mp.get(sum-1));
                if(!mp.containsKey(sum))
                {
                     mp.put(sum,mp.get(sum-1));
                }
               
            }
            else
            {
                if(!mp.containsKey(sum))
                {
                    mp.put(sum,i);
                }
            }
        }
        return ans;
    }
}