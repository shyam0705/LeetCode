class Solution {
    
  
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum | nums[i];
        }
       
        int[] closest=new int[32];
        for(int i=0;i<32;i++)
        {
            closest[i]=n;
        }
        int ans=Integer.MAX_VALUE;
        int start_index=0;
        int end_index=0;
        int[] arr=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            int num=nums[i];
            int max=0;
            for(int j=0;j<32;j++)
            {
                if(((num>>j)&1)==1)
                {
                   closest[j]=i; 
                }
                if(closest[j]!=n)
                {
                    max=Math.max(max,closest[j]);
                }
            }
            arr[i]=Math.max(max-i+1,1);
           
        }
        return arr;
      
        
    }
}