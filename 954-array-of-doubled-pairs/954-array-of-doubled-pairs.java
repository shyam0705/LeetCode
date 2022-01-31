class Solution {
    public boolean canReorderDoubled(int[] arr) {
        List<Integer>l=new ArrayList<>();
         int n=arr.length;
         for(int i=0;i<n;i++)
          {
             l.add(arr[i]);
          }
        Collections.sort(l,(a,b)->{
            return Math.abs(a)-Math.abs(b);
        });
       
        int count=n/2;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int num=l.get(i);
            if(num%2==0 && mp.containsKey(num/2))
            {
                int tmp=mp.get(num/2);
                if((tmp-1)!=0)
                {
                    mp.put(num/2,tmp-1);
                }
                else
                {
                    mp.remove(num/2);
                }
                count--;
            }
            else
            {
                mp.put(num,mp.getOrDefault(num,0)+1);
            }
            
        }
        return count==0;
    }
}