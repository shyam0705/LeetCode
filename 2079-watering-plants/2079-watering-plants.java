class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int current=capacity;
        int n=plants.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(current<plants[i])
            {
                count=count+2*(i-1+1)+1;
                current=capacity-plants[i];
            }
            else
            {
                current=current-plants[i];
                count++;
            }
        }
        return count;
    }
}