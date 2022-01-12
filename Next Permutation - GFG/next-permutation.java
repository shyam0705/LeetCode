// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static void reverse(int[] arr,int l,int r)
    {
        while(l<r)
        {
            int tmp=arr[l];
            arr[l]=arr[r];
            arr[r]=tmp;
            l++;
            r--;
        }
    }
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int n=N;
        int j=n-2;
        List<Integer>ans=new ArrayList<>();
        while(j>=0 && arr[j]>=arr[j+1])
        {
            j--;
        }
        if(j==-1)
        {
            reverse(arr,0,n-1);
            for(int i=0;i<n;i++)
            {
                ans.add(arr[i]);
            }
            return ans;
        }
        for(int k=n-1;k>j;k--)
        {
            if(arr[k]>arr[j])
            {
                int tmp=arr[j];
                arr[j]=arr[k];
                arr[k]=tmp;
                break;
            }
        }
        reverse(arr,j+1,n-1);
        for(int i=0;i<n;i++)
            {
                ans.add(arr[i]);
            }
        return ans;
        
        
    }
}