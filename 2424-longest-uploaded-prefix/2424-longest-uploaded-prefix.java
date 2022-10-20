class LUPrefix {

    
    int[] arr;
    int i;
    public LUPrefix(int n) {
        arr=new int[n+2];
        i=1;
    }
    
    public void upload(int video) {
        arr[video]=1;
    }
    
    public int longest() {
        int val=0;
        while(arr[i]==1)
        {
            i++;
        }
        return i-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */