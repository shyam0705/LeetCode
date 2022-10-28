class Solution {
    // class Node{
    //     String s;
    //     String sorted;
    //     Node(String s,String sortred)
    //     {
    //         this.s=s;
    //         this.sorted=sorted;
    //     }
    // }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String,ArrayList<String>>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char[] sorted_arr=strs[i].toCharArray();
            Arrays.sort(sorted_arr);
            String tmp="";
            for(int j=0;j<sorted_arr.length;j++)
            {
                tmp+=sorted_arr[j];
            }
            if(mp.containsKey(tmp))
            {
                mp.get(tmp).add(strs[i]);
            }
            else
            {
                ArrayList<String>l=new ArrayList<>();
                l.add(strs[i]);
                mp.put(tmp,l);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>>e:mp.entrySet())
        {
            ans.add(e.getValue());
        }
        return ans;
    }
}