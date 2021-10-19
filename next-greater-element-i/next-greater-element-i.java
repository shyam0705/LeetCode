class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] ans=new int[n];
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            mp.put(nums2[i],i);
        }
        Stack<Integer>s=new Stack<>();
        int[] tmp=new int[m];
        tmp[m-1]=-1;
        s.push(nums2[m-1]);
        for(int i=m-2;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=nums2[i])
            {
                s.pop();
            }
            if(s.size()==0)
            {
                tmp[i]=-1;
            }
            else
            {
                tmp[i]=s.peek();
            }
            s.push(nums2[i]);
        }
        for(int i=0;i<n;i++)
        {
            int index=mp.get(nums1[i]);
            ans[i]=tmp[index];
        }
        return ans;
    }
}