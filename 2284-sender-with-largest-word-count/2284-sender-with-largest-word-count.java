class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer>mp=new HashMap<>();
        int n=messages.length;
        for(int i=0;i<n;i++)
        {
            mp.put(senders[i],0);
        }
        for(int i=0;i<n;i++)
        {
            int m=messages[i].split(" ").length;
            mp.put(senders[i],mp.get(senders[i])+m);
        }
        String ans=senders[0];
        int max=mp.get(senders[0]);
        for(int i=1;i<n;i++)
        {
            if(mp.get(senders[i])>max || (mp.get(senders[i])==max && senders[i].compareTo(ans)>0))
            {
                ans=senders[i];
                max=mp.get(senders[i]);
            }
           
        }
        return ans;
        
    }
}