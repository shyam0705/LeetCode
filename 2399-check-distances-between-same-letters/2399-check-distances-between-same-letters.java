class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int n=s.length();
        int[] arr=new int[26];
        Arrays.fill(arr,-1);
        for(int i=0;i<n;i++)
        {
           char c=s.charAt(i);
           if(arr[c-'a']==-1)
           {
            arr[c-'a']=i;   
           }
          else
          {
              arr[c-'a']=i-arr[c-'a']-1;
          }
        }
        
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=-1 && arr[i]!=distance[i])
                return false;
        }
        return true;
    }
}