class Solution {
    String ans;
    boolean check;
    HashSet<String>hs;
    int n;
    public void find(String current,int index)
    {
        if(check)
        {
            return;
        }
        if(index==n)
        {
            if(!hs.contains(current))
            {
                ans=current;
                check=true;
            }
            return;
        }
        find(current+"0",index+1);
        find(current+"1",index+1);
    }
    public String findDifferentBinaryString(String[] nums) {
        ans="";
        hs=new HashSet<>();
        n=nums.length;
        for(int i=0;i<n;i++)
        {
            hs.add(nums[i]);
        }
        find("",0);
        return ans;
    }
}