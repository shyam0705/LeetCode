//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int n=S.length();
        int m=T.length();
        
        int i=0;
        int j=0;
        
        while(i<n && j<m)
        {
            if(S.charAt(i)==T.charAt(j))
            {
                i++;
                j++;
            }
            else if(Character.isDigit(T.charAt(j)))
            {
                int c=0;
                while(j<m && Character.isDigit(T.charAt(j)))
                {
                    int tmp=T.charAt(j)-'0';
                    c=c*10+tmp;
                    j++;
                }
                i=i+c;
            }
            else
            {
                return 0;
            }
        }
        
        if(i==n && j==m)
            return 1;
        return 0;
    }
}