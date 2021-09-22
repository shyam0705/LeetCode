class Solution {
    public int recur(int l,int r,int target,ArrayList<Integer> nums)
    {
        int ans=l-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums.get(mid)>target)
            {
                r=mid-1;
            }
            else
            {
                ans=Math.max(ans,mid);
                l=mid+1;
            }
        }
        return ans;
    }
    public int minOperations(int[] nums) {
        int n=nums.length;
        int count=0;
        Arrays.sort(nums);
        ArrayList<Integer>l=new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count++;
            }
            else{
                l.add(nums[i]);
            }
        }
        int m=n;
        n=l.size();
        int ans=Integer.MAX_VALUE;
        //System.out.println(n);
        for(int  i=0;i<n;i++)
        {
            if(i==0)
            {
                int index=recur(1,n-1,l.get(i)+(m-1),l); 
                int tmp=(n-1-index);
                ans=Math.min(ans,tmp);
                
            }
            else if(i==n-1)
            {
                ans=Math.min(ans,i);
            }
            else
            {
                int index=recur(i+1,n-1,l.get(i)+(m-1),l);
                int tmp=i+(n-1-index);
                ans=Math.min(ans,tmp);
            }
            //System.out.println(ans);
        }
        return count+ans;
        
    }
}