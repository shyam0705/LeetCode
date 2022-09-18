class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=-1;
        right[n-1]=-1;
        
        //build left
        int max=arr[0];
        for(int i=1;i<n;i++)
        {
           if(arr[i]>=max)
           {
               max=arr[i];
               left[i]=-1;
           }
           else
           {
               left[i]=max;
           }
        }
        
        
        //build right
        max=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
           if(arr[i]>=max)
           {
               max=arr[i];
               right[i]=-1;
           }
           else
           {
               right[i]=max;
           }
        }
        
        
    
        //cal height for every index
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(left[i]!=-1 && right[i]!=-1)
            {
                
                if(left[i]!=-1 && right[i]!=-1)
                {
                    int height=Math.min(right[i],left[i])-arr[i];
                    ans=ans+height;
                }
            }
        }
        return ans;
    }
}