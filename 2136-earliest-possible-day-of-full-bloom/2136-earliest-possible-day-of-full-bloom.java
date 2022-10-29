class Solution {
    class Node{
        int plant;
        int grow;
        Node(int plant,int grow)
        {
            this.plant=plant;
            this.grow=grow;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        ArrayList<Node>l=new ArrayList<>();
        int n=plantTime.length;
        for(int i=0;i<n;i++)
        {
            l.add(new Node(plantTime[i],growTime[i]));
        }
        Collections.sort(l,(a,b)->{
            return b.grow-a.grow;
        });
        
        int plant=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,l.get(i).grow+plant+l.get(i).plant);
            plant=plant+l.get(i).plant;
        }
        return ans;
    }
}



