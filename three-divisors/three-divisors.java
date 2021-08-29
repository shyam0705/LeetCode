class Solution {
   public boolean isThree(int n) {
        int temp = 1;
        int count = 0;
        while(temp <= n){
            if(n % temp == 0){
                count ++;
            }     
            temp ++;
        }
        
        return count == 3;
    }  
}