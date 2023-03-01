//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int Q = Integer.parseInt(str[1]);
			int [][] U = new int[Q][3];
			int i = 0;
			while(i < Q) {
				str = br.readLine().trim().split(" ");
				U[i][0] = Integer.parseInt(str[0]);
				U[i][1] = Integer.parseInt(str[1]);
				U[i][2] = Integer.parseInt(str[2]);
				i++;
			}
			Solution obj = new Solution();
			int [] arr = obj.updateQuery(N, Q, U);
			for(int j: arr) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] updateQuery(int N, int Q, int [][]U){
        //Write your code here
        
        int[][] ans=new int[N+1][32];
        for(int i=0;i<Q;i++)
        {
            int l=U[i][0]-1;
            int r=U[i][1]-1;
            int x=U[i][2];
            
            for(int j=0;j<32;j++)
            {
                if(((x>>j)&1)==1)
                {
                    ans[l][j]+=1;
                    ans[r+1][j]-=1;
                }
            }
        }
        
        for(int i=1;i<=N;i++)
        {
            for(int j=0;j<32;j++)
            {
                ans[i][j]+=ans[i-1][j];
            }
        }
        
        int[] a=new int[N];
        for(int i=0;i<N;i++)
        {
            int tmp=0;
            for(int j=0;j<32;j++)
            {
                if(ans[i][j]>0)
                {
                    tmp=tmp+(1<<j);
                }
                
            }
            a[i]=tmp;
        }
        
        return a;
        
    }
}