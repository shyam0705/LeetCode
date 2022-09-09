class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(b[0]==a[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });
        int max=arr[0][1];
        int count=0;
        for(int i=1;i<n;i++)
        {
            
            if(arr[i][1]>=max)
            {
                max=arr[i][1];
            }
            else
            {
              
                count++;
            }
        }
        return count;
    }
}