// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        int total=0;
        int maxr=r-1;
        int minr=0;
        int maxc=c-1;
        int minc=0;
        ArrayList<Integer>ans=new ArrayList<>();
        while(minr<=maxr && maxc>=minc && total<r*c)
        {
            for(int i=minc;i<=maxc && total<r*c ;i++)
            {
                ans.add(matrix[minr][i]);
                total++;
            }
            minr++;
            for(int i=minr;i<=maxr&&total<r*c;i++)
            {
                ans.add(matrix[i][maxc]);
                total++;
            }
            maxc--;
            for(int i=maxc;i>=minc&&total<r*c;i--)
            {
                ans.add(matrix[maxr][i]);
                 total++;
            }
            maxr--;
            for(int i=maxr;i>=minr&&total<r*c;i--)
            {
                ans.add(matrix[i][minc]);
                total++;
            }
            minc++;
        }
        return ans;
    }
}
