class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int j=n-2;
        while(j>=0 && arr[j+1]<=arr[j])
        {
            j--;
        }
        if(j==-1)
        {
            Arrays.sort(arr);
            return;
        }
        for(int i=n-1;i>j;i--)
        {
            if(arr[i]>arr[j])
            {
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                break;
            }
        }
        //System.out.println(j);
        ArrayList<Integer>l=new ArrayList<>();
        for(int i=j+1;i<n;i++)
        {
            l.add(arr[i]);
        }
        Collections.sort(l);
        /*for(int i=0;i<l.size();i++)
        {
            System.out.print(l.get(i)+" ");
        }*/
        int index=0;
        for(int i=j+1;i<n;i++)
        {
            arr[i]=l.get(index);
            index++;
        }
        
        
    }
}