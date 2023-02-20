//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
	 
		//code here
		if(N==1)
		{
		    return 0;
		}
		if(N==2)
		{
		    return 3;
		}
		long upper_prev=3;
		long lower_prev=2;
		long mod=1000000007;
		for(int i=3;i<=N;i++)
		{
		    long tmp=upper_prev;
		    upper_prev=(3*lower_prev)%mod;
		    lower_prev=((2*lower_prev)%mod+tmp)%mod;
		}
		return (int)upper_prev;
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends