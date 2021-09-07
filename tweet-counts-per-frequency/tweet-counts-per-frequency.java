class TweetCounts {
    HashMap<String,List<Integer>>mp;
    public TweetCounts() {
        mp=new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if(mp.containsKey(tweetName))
        {
            mp.get(tweetName).add(time);
        }
        else
        {
            List<Integer>tmp=new ArrayList<>();
            tmp.add(time);
            mp.put(tweetName,tmp);
        }
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer>ans=new ArrayList<>();
        if(!mp.containsKey(tweetName))return ans;
        else
        {
            List<Integer>l=mp.get(tweetName);
            Collections.sort(l);
            int i=0;
            int split = 1;
            int n=l.size();
            if (freq.matches("minute")) {
                split = 60;
            } else if (freq.matches("hour")) {
                split = 3600;
            } else if (freq.matches("day")) {
                split = 86400;
            }
            while(startTime<=endTime)
            {
                while(i<n && l.get(i)<startTime)
                {
                    i++;
                    continue;
                }
                int count=0;
                while(i<n && l.get(i)<=Math.min(startTime+split-1, endTime))
                {
                    count++;
                    i++;
                }
                ans.add(count);
                startTime=startTime+split;
            }
            return ans;
            
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */