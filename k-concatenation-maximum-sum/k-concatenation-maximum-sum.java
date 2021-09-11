class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
            int n=arr.length;
            long max=arr[0];
		    long max_ending=arr[0];
            long m=1000000007;
		    for(int i=1;i<n;i++)
		    {
		        max_ending=Math.max(max_ending+arr[i],arr[i]);
		        max=Math.max(max_ending,max);
		    }
		    if(k==1)
		    {
                if(max<0)
                {
                    return 0;
                }
                else
                {
                    max=(max%m);
                    return (int)max;
                }
                
		        //System.out.println(max);
		    }
		    else{
    		    long sum1=arr[n-1];
    		    long max_sum1=arr[n-1];
    		    for(int i=n-2;i>=0;i--)
    		    {
    		        sum1=sum1+arr[i];
    		        max_sum1=Math.max(sum1,max_sum1);
    		    }
    		    long sum2=arr[0];
    		    long max_sum2=arr[0];
    		    for(int i=1;i<n;i++)
    		    {
    		        sum2=sum2+arr[i];
    		        max_sum2=Math.max(sum2,max_sum2);
    		    }
    		    //System.out.print(max+" "+max_sum1+" "+max_sum2);
    		    long ans=Math.max(max_sum1+max_sum2,max);
    		    ans=(Math.max(ans,max_sum1+max_sum2+(k-2)*(sum2)));
                if(ans<0)
                {
                    return 0;
                }
                else
                {
                    ans=ans%m;
                    return (int)ans;
                }
            }
    }
}