//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
        
       
        int n=N;
        int smallest=Integer.MAX_VALUE;
        long count=0;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            long sq=(long)B[i]/2;
            sum=sum+(long)sq*A[i]*2;
            
            if(sq>0)
            {
                smallest=Math.min(smallest,A[i]*2);
            }
            count=count+sq;
        }
        
        // System.out.println(smallest);
        if(count%2!=0)
        {
            sum=sum-smallest;
        }
        return sum;
    }
} 