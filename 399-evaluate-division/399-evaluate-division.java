class Solution {
    HashMap<String,ArrayList<String>>adj;
    HashMap<String,Double>cost;
    HashSet<String>visited;
    public double dfs(String a,String b)
    {
        String s=a+"$"+b;
        visited.add(a);
        if(cost.containsKey(s))
        {
            return cost.get(s);
        }
        if(!adj.containsKey(a))
        {
            return -1;
        }
        for(String el:adj.get(a))
        {
            if(!visited.contains(el))
            {
                
                String tmp=a+"$"+el;
                double tmp_ans=dfs(el,b);
                if(tmp_ans!=-1)
                {
                    return tmp_ans*cost.get(tmp);
                }
            }
            
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        cost=new HashMap<>();
        adj=new HashMap<>();
        visited=new HashSet<>();
        int i=0;
        for(List<String>eq:equations)
        {
            String s1=eq.get(0);
            String s2=eq.get(1);
            double value=values[i];
            String s=s1+"$"+s2;
            cost.put(s,value);
            cost.put(s2+"$"+s1,1/value);
            if(adj.containsKey(s1))
            {
                adj.get(s1).add(s2);
            }
            else
            {
                ArrayList<String>tmp=new ArrayList<>();
                tmp.add(s2);
                adj.put(s1,tmp);
            }
            if(adj.containsKey(s2))
            {
                adj.get(s2).add(s1);
            }
            else
            {
                ArrayList<String>tmp=new ArrayList<>();
                tmp.add(s1);
                adj.put(s2,tmp);
            }
            i++;
        }
        int n=queries.size();
        double[] ans=new double[n];
        for(i=0;i<n;i++)
        {
            visited=new HashSet<>();
            ans[i]=dfs(queries.get(i).get(0),queries.get(i).get(1));
        }
        return ans;
    }
}