class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>>ans=new ArrayList<>();
        int n=arr.length;
        int prevDiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++)
        {
           
            int d=arr[i]-arr[i-1];
            if(d<prevDiff)
            {
                prevDiff=d;
                
            }
           
        }
        for(int i=1;i<n;i++)
        {
            int d=arr[i]-arr[i-1];
            if(d==prevDiff)
            {
                List<Integer>tmp=new ArrayList<>();
                tmp.add(arr[i-1]);
                tmp.add(arr[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}