class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,ArrayList<String>>mp=new HashMap<>();
        for(String s:paths)
        {
            String[] arr=s.split(" ");
            for(int i=1;i<arr.length;i++)
            {
                String current=arr[i];
                int start=current.indexOf('(');
                int end=current.indexOf(')');
                String content=current.substring(start+1,end);
                String name=current.substring(0,start);
                String path=arr[0]+'/'+name;
                if(mp.containsKey(content))
                {
                    mp.get(content).add(path);
                    
                }
                else
                {
                    ArrayList<String>l=new ArrayList<>();
                    l.add(path);
                    mp.put(content,l);
                }
               
            }
        }
        List<List<String>>ans=new ArrayList<>();
        mp.forEach((k,v)->{
            if(v.size()>1)
                ans.add(v);
        });
        return ans;
    }
}