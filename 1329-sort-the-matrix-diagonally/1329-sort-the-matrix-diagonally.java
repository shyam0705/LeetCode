class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        HashMap<Integer,PriorityQueue>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int diff=j-i;
                if(mp.containsKey(diff))
                {
                    mp.get(diff).add(mat[i][j]);
                }
                else
                {
                    PriorityQueue<Integer>tmp=new PriorityQueue<>();
                    tmp.add(mat[i][j]);
                    mp.put(diff,tmp);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int diff=j-i;
                PriorityQueue<Integer>tmp=mp.get(diff);
                mat[i][j]=tmp.remove();
            }
        }
        return mat;
    }
}