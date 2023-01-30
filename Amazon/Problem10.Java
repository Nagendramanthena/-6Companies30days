class TweetCounts {
    
    HashMap<String,List<Integer>> tweetCount;

    public TweetCounts() {
        tweetCount =  new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        List<Integer> temp = tweetCount.getOrDefault(tweetName,new ArrayList<>());
        temp.add(time);
        tweetCount.put(tweetName,temp);
        
    }
    
//     public void update(String tweetName,int time){
//         List<Integer> temp = tweetCount.get(tweetName);
//         int pos= getpos(time,temp);
//         temp.add(pos,time);
//         tweetCount.put(tweetName,temp);
//     }
    
//     public int getpos(int x,List<Integer> arr){
//         int low =0;
//         int high = arr.size()-1;
        
//         while(low<=high){
//             int mid = (high-low)/2+ low;
            
//             if(arr.get(mid)>x)high = mid-1;
//             else{
//                 low = mid+1;
//             }
//         }
//         return low;
//     }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> times = tweetCount.get(tweetName);
        int interval = 60;
        if(freq.equals("hour"))
            interval = interval * 60;
        if(freq.equals("day"))
            interval = interval * 60 * 24;
        
        for(int i = 0; i <= (endTime - startTime) / interval; i++)
            ans.add(0);
        for(int time : times){
            if(startTime <= time && time <= endTime){
                // get the index of which interval at current time
                int idx = (time - startTime) / interval;
                ans.set(idx, ans.get(idx)+1);
            }
        }
        
        return ans;
    }
