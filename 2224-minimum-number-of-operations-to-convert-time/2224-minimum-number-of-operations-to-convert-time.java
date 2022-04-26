class Solution {
    public int convertTime(String current, String correct) {
        String[] arr1=current.split(":");
        String[] arr2=correct.split(":");
        int h1=Integer.parseInt(arr1[0]);
        int h2=Integer.parseInt(arr2[0]);
        int m1=Integer.parseInt(arr1[1]);
        int m2=Integer.parseInt(arr2[1]);
        int t1=h1*60+m1;
        int t2=h2*60+m2;
        int diff=t2-t1;
        int count=0;
        count=count+diff/60;
        diff=diff%60;
        count=count+diff/15;
        diff=diff%15;
        count=count+diff/5;
        diff=diff%5;
        count=count+diff;
        return count;
    }
}