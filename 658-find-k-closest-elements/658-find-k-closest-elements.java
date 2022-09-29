class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            int tmp1=Math.abs(a-x);
            int tmp2=Math.abs(b-x);
            if(tmp1==tmp2)
            {
                return b-a;
            }
            return tmp2-tmp1;
        });
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            pq.add(arr[i]);
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        while(!pq.isEmpty())
        {
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}