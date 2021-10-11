class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer>ans=new ArrayList<>();
        int n=nums1.length;
         int m=nums2.length;
         int l=nums3.length;
        int[] count1=new int[101];
        int[] count2=new int[101];
        int[] count3=new int[101];
        for(int i=0;i<n;i++)
        {
            count1[nums1[i]]++;
        }
        for(int i=0;i<m;i++)
        {
            count2[nums2[i]]++;
        }
        for(int i=0;i<l;i++)
        {
            count3[nums3[i]]++;
        }
        for(int i=1;i<=100;i++)
        {
            int[] tmp=new int[3];
            tmp[0]=count1[i];
            tmp[1]=count2[i];
            tmp[2]=count3[i];
            Arrays.sort(tmp);
            if(tmp[1]>0)
            {
               ans.add(i);
            }
        }
        return ans;
        
    }
}