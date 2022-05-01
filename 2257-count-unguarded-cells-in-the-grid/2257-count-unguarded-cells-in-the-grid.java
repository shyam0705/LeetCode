class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        HashSet<String>guard_set=new HashSet<>();
        HashSet<String>walls_set=new HashSet<>();
        for(int i=0;i<guards.length;i++)
        {
            String s=guards[i][0]+"$"+guards[i][1];
            guard_set.add(s);
        }
        for(int i=0;i<walls.length;i++)
        {
            String s=walls[i][0]+"$"+walls[i][1];
            walls_set.add(s);
        }
        int[][] dp=new int[m][n];
         
        for(int i=0;i<m;i++)
        { 
            boolean guard=false;
           for(int j=0;j<n;j++)
           {
               String s=i+"$"+j;
               if(guard_set.contains(s))
               {
                   dp[i][j]=2;
                   guard=true;
               }
               else if(walls_set.contains(s))
               {
                   dp[i][j]=-1;
                   guard=false;
               }
               else
               {
                   dp[i][j]=guard?1:dp[i][j];
               }
           }
        }
       
        for(int i=0;i<m;i++)
        { 
            boolean guard=false;
           for(int j=n-1;j>=0;j--)
           {
               String s=i+"$"+j;
               if(guard_set.contains(s))
               {
                   dp[i][j]=2;
                   guard=true;
               }
               else if(walls_set.contains(s))
               {
                   dp[i][j]=-1;
                   guard=false;
               }
               else
               {
                   dp[i][j]=guard?1:dp[i][j];
               }
           }
        }
        
        for(int i=0;i<n;i++)
        { 
            boolean guard=false;
           for(int j=0;j<m;j++)
           {
               String s=j+"$"+i;
               if(guard_set.contains(s))
               {
                   dp[j][i]=2;
                   guard=true;
               }
               else if(walls_set.contains(s))
               {
                   dp[j][i]=-1;
                   guard=false;
               }
               else
               {
                   dp[j][i]=guard?1:dp[j][i];
               }
           }
        }
        for(int i=n-1;i>=0;i--)
        { 
            boolean guard=false;
           for(int j=m-1;j>=0;j--)
           {
               String s=j+"$"+i;
               if(guard_set.contains(s))
               {
                   dp[j][i]=2;
                   guard=true;
               }
               else if(walls_set.contains(s))
               {
                   dp[j][i]=-1;
                   guard=false;
               }
               else
               {
                   dp[j][i]=guard?1:dp[j][i];
               }
           }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dp[i][j]==0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}