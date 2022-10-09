class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] arr=new int[3];
        int[] last=new int[3];
        for(int i=0;i<garbage.length;i++)
        {
            String s=garbage[i];
            for(char c:s.toCharArray())
            {
                if(c=='M')
                {
                    arr[0]++;
                    last[0]=i;
                }
                else if(c=='P')
                {
                    arr[1]++;
                    last[1]=i;
                }
                else
                {
                    arr[2]++;
                    last[2]=i;
                }
            }
        }
        int count=arr[0]+arr[1]+arr[2];
        for(int i=0;i<3;i++)
        {
            for(int j=1;j<=last[i];j++)
            {
                count=count+travel[j-1];
            }
        }
        return count;
    }
}