class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(items1,(a,b)->{
            return a[0]-b[0];
        });
        Arrays.sort(items2,(a,b)->{
            return a[0]-b[0];
        });
        int i=0;
        int j=0;
        int n=items1.length;
        int m=items2.length;
        while(i<n && j<m)
        {
            if(items1[i][0]==items2[j][0])
            {
                List<Integer>tmp=Arrays.asList(items1[i][0],items1[i][1]+items2[j][1]);
                ans.add(tmp);
                i++;
                j++;
            }
            else if(items1[i][0]<items2[j][0])
            {
                List<Integer>tmp=Arrays.asList(items1[i][0],items1[i][1]);
                ans.add(tmp);
                i++;
            }
            else
            {
                List<Integer>tmp=Arrays.asList(items2[j][0],items2[j][1]);
                ans.add(tmp);
                j++;
            }
        }
        while(i<n)
        {
            
            List<Integer>tmp=Arrays.asList(items1[i][0],items1[i][1]);
            ans.add(tmp);
            i++;
        }
        while(j<m)
        {
            
            List<Integer>tmp=Arrays.asList(items2[j][0],items2[j][1]);
            ans.add(tmp);
            j++;
        }
        return ans;
    }
}