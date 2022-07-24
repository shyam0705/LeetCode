class Solution {
    class Node{
        int index;
        int value;
        Node(int index,int value)
        {
            this.index=index;
            this.value=value;
        }
    }
    List<Integer>ans;
    public void mergeSort(Node[] arr,int l,int r)
    {
        if(l<r)
        {
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    public void merge(Node[] arr,int l,int mid,int r)
    {
        if(l<r)
        {
           Node[] tmp=new Node[r-l+1];
           int i=l;
           int j=mid+1;
            int k=0;
            while(i<=mid && j<=r)
            {
                if(arr[i].value<=arr[j].value)
                {
                    tmp[k]=arr[i];
                    ans.set(arr[i].index,ans.get(arr[i].index)+j-mid-1);
                    i++;
                    k++;
                }
                else
                {
                    tmp[k]=arr[j];
                    
                    j++;
                    k++;
                }
            }
            while(i<=mid)
            {
                tmp[k]=arr[i];
                ans.set(arr[i].index,ans.get(arr[i].index)+r-mid);
                i++;
                k++;
            }
            while(j<=r)
            {
                tmp[k]=arr[j];
                j++;
                k++;
            }
            for(int a=l;a<=r;a++)
            {
                arr[a]=tmp[a-l];
            }
        }
    }
    public List<Integer> countSmaller(int[] nums) {
         ans=new ArrayList<Integer>();
         int n=nums.length;
         Node[] arr=new Node[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new Node(i,nums[i]);
            ans.add(0);
        }
        mergeSort(arr,0,n-1);
        return ans;
    }
}