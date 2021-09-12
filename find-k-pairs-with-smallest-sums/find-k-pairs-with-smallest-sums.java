class Solution {
   public class Pair {
    int x;
    int y;
    int sum;
    Pair(int x,int y,int sum)
    {
        this.x=x;
        this.y=y;
        this.sum=sum;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sum;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (sum != other.sum)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
    
}
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
           
            return a.sum-b.sum;
        });
        int n=nums1.length;
        int m=nums2.length;
        HashSet<Pair>hs=new HashSet<>();
        Pair in=new Pair(0,0,nums1[0]+nums2[0]);
        hs.add(in);
        pq.add(in);
        int count=0;
        List<List<Integer>>ans=new ArrayList<>();
        while(!pq.isEmpty() && count!=k)
        {
            Pair tmp=pq.remove();
            
            List<Integer>tmp_list=new ArrayList<>();
            
            tmp_list.add(nums1[tmp.x]);
            tmp_list.add(nums2[tmp.y]);
            ans.add(tmp_list);
            if(tmp.x+1<n)
            {
                Pair newP=new Pair(tmp.x+1,tmp.y,nums1[tmp.x+1]+nums2[tmp.y]);
                if(!hs.contains(newP))
                {
                    pq.add(newP);
                    hs.add(newP);
                }
            }
            if(tmp.y+1<m && !hs.contains(tmp.x+"#"+(tmp.y+1)))
            {
                
                Pair newP=new Pair(tmp.x,tmp.y+1,nums1[tmp.x]+nums2[tmp.y+1]);
                if(!hs.contains(newP))
                {
                    pq.add(newP);
                    hs.add(newP);
                }
            }
            count++;
        }
        return ans;
    }
}