//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public static int isPos(int n)
    {
        if(n>=0)
        {
            return 1;
        }
        return -1;
    }
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        Stack<Integer>s=new Stack<>();
        int n=arr.length;
        ArrayList<Integer>ans=new ArrayList<>();
        
        s.add(arr[0]);
        for(int i=1;i<n;i++)
        {
            if(s.isEmpty() || (isPos(arr[i])*isPos(s.peek())==1))
            {
                s.push(arr[i]);
            }
            else
            {
                s.pop();
            }
        }
        
        while(!s.isEmpty())
        {
            ans.add(s.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}
