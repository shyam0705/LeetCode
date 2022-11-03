class Solution {
    
    class Node{
        String id;
        int total_view;
        int max_view;
        Node(String id,int total_views,int max_view)
        {
            this.id=id;
            this.total_view=total_views;
            this.max_view=max_view;
        }
    }
    
    public String findSmaller(String s1,String s2)
    {
        int n=s1.length();
        int m=s2.length();
        
        int i=0;
        int j=0;
        while(i<n && j<m)
        {
            if(s1.charAt(i)<s2.charAt(j))
            {
                return s1;
            }
            else if(s1.charAt(i)>s2.charAt(j))
            {
                return s2;
            }
            i++;
            j++;
        }
        if(i==n)
            return s1;
        return s2;
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        HashMap<String,Node>mp=new HashMap<>();
        List<List<String>>ans=new ArrayList<>();
        int n=creators.length;
        for(int i=0;i<n;i++)
        {
            String s=creators[i];
            String id=ids[i];
            int view=views[i];
            if(mp.containsKey(s))
            {
                Node tmp=mp.get(s);
                tmp.total_view+=view;
                if(view>tmp.max_view)
                {
                    tmp.max_view=view;
                    tmp.id=id;
                }
                else if(view==tmp.max_view)
                {
                    tmp.id=findSmaller(id,tmp.id);
                }
            }
            else
            {
                mp.put(s,new Node(id,view,view));
            }
        }
        

        int current_max=0;
        for(Map.Entry<String,Node>e:mp.entrySet())
        {
            String key=e.getKey();
            Node value=e.getValue();
            
            if(value.total_view>current_max)
            {
                List<String>tmp=new ArrayList<>();
                tmp.add(key);
                tmp.add(value.id);
                ans=new ArrayList<>();
                ans.add(tmp);
                
                current_max=value.total_view;
            }
            else if(value.total_view==current_max)
            {
                List<String>tmp=new ArrayList<>();
                tmp.add(key);
                tmp.add(value.id);
                ans.add(tmp);
            }
        }
        return ans;
    }
}