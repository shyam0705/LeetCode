class Solution {
    class Pair{
        int sum,index;
        Pair(int sum,int index)
        {
            this.sum=sum;
            this.index=index;
        }
    }
    public int stoneGameVI(int[] arr1, int[] arr2) {
        int n=arr1.length;
        ArrayList<Pair>l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            l.add(new Pair(arr1[i]+arr2[i],i));
        }
        Collections.sort(l,(a,b)->{
            return b.sum-a.sum;
        });
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
              sum1=sum1+arr1[l.get(i).index];  
            }
            else
            {
                sum2=sum2+arr2[l.get(i).index];
            }
        }
        if(sum1>sum2)
        {
            return 1;
        }
        else if(sum1<sum2)
            return -1;
        else 
            return 0;
        
    }
}