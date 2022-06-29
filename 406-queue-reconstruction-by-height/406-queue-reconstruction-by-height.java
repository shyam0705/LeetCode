class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])
            {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int[][] ans=new int[n][2];
        // int[] prefix=new int[n];
        for(int i=0;i<n;i++)
        {
             // prefix[i]=0;
            ans[i][0]=-1;
        }
        for(int i=0;i<n;i++)
        {
            // int index=people[i][1]+prefix[people[i][1]];
            // //System.out.println(index);
            // while(ans[index][0]!=-1)
            // {
            //     index++;
            // }
            int req=people[i][1];
            int index=0;
            while(req>0 || ans[index][0]!=-1)
            {
                if(ans[index][0]==-1)
                {
                    req--;
                }
                index++;
            }
            ans[index][0]=people[i][0];
            ans[index][1]=people[i][1];
            // for(int j=index;j<n;j++)
            // {
            //     prefix[j]++;
            // }
            
        }
        return ans;
    }
}