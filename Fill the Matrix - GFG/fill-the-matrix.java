//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		x=x-1;
		y=y-1;
		int[] arr1={0,0,N-1,N-1};
		int[] arr2={0,M-1,0,M-1};
		int ans=0;
		for(int i=0;i<4;i++)
		{
		    int dis=Math.abs(arr1[i]-x)+Math.abs(arr2[i]-y);
		    ans=Math.max(ans,dis);
		}
		return ans;
		
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends