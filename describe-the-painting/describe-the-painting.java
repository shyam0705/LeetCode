class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> res = new ArrayList<>();
        int len=0;
        for(int[] segment : segments) //find max len of painting
            len = Math.max(len, 1+segment[1]);   

        long[] beg = new long[len]; //allocate buf for begs
        long[] end = new long[len]; //allocate buf for ends
        
        for(int[] segment : segments){
            beg[segment[0]] += segment[2];  //mark all segments' begs as color
            end[segment[1]] -= segment[2];  //mark all segments' ends as -color 
        }
        
        int i=-1,j=1;
        long sum=0;
        while(j<len){
            while(j<len && beg[j]==0 && end[j]==0) //go through the buffs,  until we find beg or end or both
                j++;
            if(j<len){ //we found beg or end or both
                if(sum!=0) //sum equals zero in unpainted areas
                    res.add(Arrays.asList(Long.valueOf(i), Long.valueOf(j), sum)); //add range from last occurrence to the current place
                sum+=end[j]+beg[j]; //adjust sum with beg or end or both
                i=j; //store current place as last occurrence
            }
            j++; //go ahead
        }
        return res;
    }
}