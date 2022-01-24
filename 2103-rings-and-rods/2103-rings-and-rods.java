class Solution {
    public int countPoints(String rings) {
        int n=rings.length();
        int[][] arr=new int[10][3];
        for(int i=0;i<n/2;i++)
        {
            char r=rings.charAt(2*i);
            char road=rings.charAt(2*i+1);
            if(r=='R')
            {
               arr[road-'0'][0]=1; 
            }
            else if(r=='B')
            {
                arr[road-'0'][1]=1; 
            }
            else
            {
                arr[road-'0'][2]=1; 
            }
        }
        int count=0;
        for(int i=0;i<10;i++)
        {
            int tmp=arr[i][0]+arr[i][1]+arr[i][2];
            if(tmp==3)count++;
        }
        return count;
    }
}