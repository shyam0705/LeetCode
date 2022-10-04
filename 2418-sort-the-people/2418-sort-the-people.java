class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String>mp=new TreeMap<>((a,b)->{
            return b-a;
        });
        for(int i=0;i<names.length;i++)
        {
            mp.put(heights[i],names[i]);
        }
        String[] ans=new String[names.length];
        int i=0;
        for(Map.Entry<Integer, String> entry : mp.entrySet()) {
           ans[i]=entry.getValue();
            i++;
        }
        return ans;
 
    }
}