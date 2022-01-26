class RangeFreqQuery {
    HashMap<Integer,ArrayList<Integer>>mp;
    public RangeFreqQuery(int[] arr) {
        mp=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(mp.containsKey(arr[i]))
            {
                mp.get(arr[i]).add(i);
            }
            else
            {
                ArrayList<Integer>tmp=new ArrayList<Integer>();
                tmp.add(i);
                mp.put(arr[i],tmp);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        if(!mp.containsKey(value))
            return 0;
        ArrayList<Integer>indexes=mp.get(value);
        int tmp1=searchGreater(indexes,left);
        int tmp2=searchSmaller(indexes,right);
        // System.out.println(tmp1);
        //   System.out.println(tmp2);
        if(tmp1==-1 || tmp2==-1)
            return 0;
        return Math.max(tmp2-tmp1+1,0);
    }
    public int searchGreater(ArrayList<Integer>arr,int value)
    {
        int n=arr.size();
        int l=0;
        int r=n-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr.get(mid)>=value)
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
    public int searchSmaller(ArrayList<Integer>arr,int value)
    {
        int n=arr.size();
        int l=0;
        int r=n-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr.get(mid)<=value)
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return ans;
    }
    
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */