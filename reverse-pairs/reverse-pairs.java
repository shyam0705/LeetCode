class Solution {
    int count;
    public void mergeSort(int[] arr,int l,int r)
    {
        if(l>=r)
        {
            return;
        }
        if(l<r)
        {
            int mid=(l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            count(arr,l,mid,r);
            merge(arr,l,mid,r);
        }
    }
    public void count(int[] arr,int l,int mid,int r)
    {
        
         int i=l;
         int j=mid+1;
         while(i<=mid && j<=r)
        {
            double tmp1=(double)arr[i]/(double)2;
            double tmp2=(double)arr[j]; 
            if(tmp2<tmp1)
            {
                j++;
            }
            else
            {
                count=count+(j-mid-1);
                i++;
            }
        }
        while(i<=mid)
        {
            count=count+(j-mid-1);
            i++;
        }
    }
    public void merge(int[] arr,int l,int mid,int r)
    {
        if(l>=r)
        {
            return;
        }
        int[] tmp=new int[r-l+1];
        int i=l;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=r)
        {
            if(arr[i]<arr[j])
            {
                tmp[k]=arr[i];
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
            i++;
            k++;
        }
        while(j<=r)
        {
            tmp[k]=arr[j];
            j++;
            k++;
        }
        k=0;
        for(int m=l;m<=r;m++)
        {
            arr[m]=tmp[k];
            k++;
        }
    }
    public int reversePairs(int[] nums) {
        count=0;
        mergeSort(nums,0,nums.length-1);
        return count;
    }
}