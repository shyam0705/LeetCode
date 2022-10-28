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
            StringBuilder tmp=new StringBuilder();
            for(int j=0;j<sorted_arr.length;j++)
            {
                tmp.append(sorted_arr[j]);
            }
            String a=tmp.toString();
            if(mp.containsKey(a))
            {
                mp.get(a).add(strs[i]);
            }
            else
            {
                ArrayList<String>l=new ArrayList<>();
                l.add(strs[i]);
                mp.put(a,l);
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