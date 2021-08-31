class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr=preorder.split(",");
        int n=arr.length;
        int c=1;
        for(int i=0;i<n;i++)
        {
            
            if(c==0)
            {
                return false;
            }
            if(arr[i].equals("#"))
            {
               c--; 
            }
            else
            {
               c++; 
            }
        }
        return c==0;
    }
}