class Solution {
   class Pair{
        char c;
        int freq;
        Pair(char c,int freq)
        {
            this.c=c;
            this.freq=freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer>mp=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Pair>arr=new ArrayList<>();
        mp.forEach((k,v)->{
            arr.add(new Pair(k,v));
                    });
        Collections.sort(arr,(a,b)->{
            return b.freq-a.freq;
        });
        String ans="";
        for(Pair p:arr)
        {
             int m=p.freq;
             for(int i=0;i<m;i++)
            {
                ans=ans+p.c;
            }
        }
                  return ans;
        
    }
}