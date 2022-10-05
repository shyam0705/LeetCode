class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            
          
        int[] arr={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
        int start_m1=Integer.parseInt(arriveAlice.substring(0,2));
        int start_d1=Integer.parseInt(arriveAlice.substring(3));
        int end_m1=Integer.parseInt(leaveAlice.substring(0,2));
        int end_d1=Integer.parseInt(leaveAlice.substring(3));
        
        int start_m2=Integer.parseInt(arriveBob.substring(0,2));
        int start_d2=Integer.parseInt(arriveBob.substring(3));
        int end_m2=Integer.parseInt(leaveBob.substring(0,2));
        int end_d2=Integer.parseInt(leaveBob.substring(3));
            
        int l_m1=0;
        int r_m1=0;
        for(int i=1;i<start_m1;i++)
        {
            l_m1+=arr[i-1];
        }
        l_m1+=start_d1;
        
        for(int i=1;i<end_m1;i++)
        {
            r_m1+=arr[i-1];
        }
        r_m1+=end_d1;
        
        int l_m2=0;
        int r_m2=0;
        for(int i=1;i<start_m2;i++)
        {
            l_m2+=arr[i-1];
        }
        l_m2+=start_d2;
          
        for(int i=1;i<end_m2;i++)
        {
            r_m2+=arr[i-1];
        }
        r_m2+=end_d2;
        
        int start=Math.max(l_m1,l_m2);
        int end=Math.min(r_m1,r_m2);
        
        // System.out.println(start+" "+end);
        return Math.max(0,end-start+1);
        
            
    }
}