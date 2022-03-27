 class Pair{
    int x,y;
     Pair(int x,int y){
         this.x=x;
         this.y=y;
     }
}
class Solution {
   
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(b.x==a.x)
            {
                return b.y-a.y;
            }
            return b.x-a.x;
        });
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                }
            }
            pq.add(new Pair(count,i));
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            if(pq.size()>0)
            {
                Pair tmp=pq.remove();
                ans[k-i-1]=tmp.y;
            }   
           
        }
        return ans;
    }
}