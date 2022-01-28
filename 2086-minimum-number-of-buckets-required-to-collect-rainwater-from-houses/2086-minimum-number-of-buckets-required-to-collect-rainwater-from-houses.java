class Solution {
    public int minimumBuckets(String street) {
        int n=street.length();
        boolean[] visited=new boolean[n];
        int count=0;
        char[] arr=street.toCharArray();
        for(int i=1;i<n-1;i++)
        {
            if(arr[i]=='.' && arr[i+1]=='H' && arr[i-1]=='H' && !visited[i+1] && !visited[i-1])
            {
                visited[i+1]=true;
                visited[i-1]=true;
                count++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i] && arr[i]=='H')
            {
                if(!((i>0 && arr[i-1]=='.') || (i<n-1 && arr[i+1]=='.')))
                {
                 return -1;   
                }
                else
                {
                    count++;
                }
            }
            
        }
        return count;
    }
}