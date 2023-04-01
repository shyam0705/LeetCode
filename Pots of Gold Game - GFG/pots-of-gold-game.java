//{ Driver Code Starts
import java.util.*;
import java.lang.Math;
class Pots{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] a =new  int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			GfG g = new GfG();
			System.out.println(g.maxCoins(a,n));
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
    
    static int[][] dp;
    public static int recur(int[] arr,int l,int r)
    {
        if(l>r)
        {
            return 0;
        }
        if(l==r)
        {
            return arr[l];
        }
        
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        
        int tmp1=arr[l]+Math.min(recur(arr,l+2,r),recur(arr,l+1,r-1));
        int tmp2=arr[r]+Math.min(recur(arr,l,r-2),recur(arr,l+1,r-1));
        dp[l][r]=Math.max(tmp1,tmp2);
        return dp[l][r];
    }
	public static int maxCoins(int A[],int n)
	{
          //add code here.
          dp=new int[n][n];
          for(int i=0;i<n;i++)
          {
              for(int j=0;j<n;j++)
              {
                  dp[i][j]=-1;
              }
          }
          
          return recur(A,0,n-1);
         
          
          
    }
}