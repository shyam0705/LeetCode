class Solution {
    class Pair{
        int index,t;
        Pair(int index,int t)
        {
            this.index=index;
            this.t=t;
        }
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        ArrayList<Pair>arr=new ArrayList<>();
        int n=flowers.length;
        int m=persons.length;
        for(int i=0;i<m;i++)
        {
            arr.add(new Pair(i,persons[i]));
        }
        Collections.sort(arr,(a,b)->{
            return a.t-b.t;
        });
        int[] dp=new int[m+1];
        for(int i=0;i<n;i++)
        {
            int l=flowers[i][0];
            int r=flowers[i][1];
            int lower=binarySearch(arr,l);
            int upper=binarySearch2(arr,r);
            dp[lower]++;
            dp[upper]--;
        }
        for(int i=1;i<=m;i++)
        {
            dp[i]+=dp[i-1];
        }
        int[] ans=new int[m];
        for(int i=0;i<m;i++)
        {
            ans[arr.get(i).index]=dp[i];
        }
        return ans;
    }
    public int binarySearch(ArrayList<Pair>arr,int target)
    {
        int l=0;
        int r=arr.size()-1;
        int ans=arr.size();
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr.get(mid).t>=target)
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
    public int binarySearch2(ArrayList<Pair>arr,int target)
    {
        int l=0;
        int r=arr.size()-1;
        int ans=arr.size();
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr.get(mid).t>target)
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
    
}