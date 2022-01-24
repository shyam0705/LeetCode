class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int currentA=capacityA;
        int currentB=capacityB;
        int n=plants.length;
        int count=0;
        if(n%2==0)
        {
            int m=n/2;
            for(int i=0;i<m;i++)
            {
                if(currentA>=plants[i])
                {
                    currentA-=plants[i];
                }
                else
                {
                    count++;
                    currentA=capacityA-plants[i];
                }
            }
            for(int j=n-1;j>=m;j--)
            {
                if(currentB>=plants[j])
                {
                    currentB-=plants[j];
                }
                else
                {
                    count++;
                    currentB=capacityB-plants[j];
                }
            }
        }
        else
        {
            int m=n/2;
           
            for(int i=0;i<m;i++)
            {
                if(currentA>=plants[i])
                {
                    currentA-=plants[i];
                }
                else
                {
                    count++;
                    currentA=capacityA-plants[i];
                }
            }
            for(int j=n-1;j>m;j--)
            {
                if(currentB>=plants[j])
                {
                    currentB-=plants[j];
                }
                else
                {
                    count++;
                    currentB=capacityB-plants[j];
                }
            }
            int max=Math.max(currentA,currentB);
            if(max<plants[m])
            {
                count++;
            }
        }
        return count;
    }
}