class Solution {
    class Pair{
        int number;
        int frequency;
        Pair(int number,int frequency)
        {
            this.number=number;
            this.frequency=frequency;
        } 
    }
    public int minSetSize(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return b.frequency-a.frequency;
        });
        mp.forEach((k,v)->{
            pq.add(new Pair(k,v));
        });
        int target=n/2;
        int count=0;
        while(!pq.isEmpty())
        {
            count++;
            Pair p=pq.remove();
            n=n-p.frequency;
            if(n<=target)
            {
                break;
            }
        }
        return count;
        
    }
}