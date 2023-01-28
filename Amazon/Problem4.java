class Node{
    String id;long totalviews;int prevmax;
    
    public Node(long tv,int pm,String id){
        this.totalviews = tv;
        this.prevmax = pm;
        this.id = id;
    }
}
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String,Node> hm = new HashMap<>();long maxviews = 0;
        for(int i=0;i<creators.length;i++){
            if(hm.containsKey(creators[i])){
                Node n = hm.get(creators[i]);
                int x = n.prevmax;String id = n.id;
                if(x<views[i]) {
                    id = ids[i];
                    x = views[i];}
                else if(x == views[i])
                    if(id.compareTo(ids[i])>0) id = ids[i];
                long y = n.totalviews;
                y += views[i];
                Node node = new Node(y,x,id);
                maxviews = Math.max(maxviews,y);
                hm.replace(creators[i],node);
            }
            else{
                maxviews = Math.max(maxviews,views[i]);
                long z = views[i];
                Node n = new Node(z,views[i],ids[i]);
                hm.put(creators[i],n);
            }
        }
        System.out.println(maxviews);
        List<List<String>> s = new ArrayList<>();
        for(Map.Entry<String,Node> entry : hm.entrySet()){
            Node n = entry.getValue();
            if(n.totalviews == maxviews){
                System.out.println(1);
                List<String> l = new ArrayList<>();
                l.add(entry.getKey());
                l.add(n.id);
                s.add(l);
            }
        }
        return s;
    }
}
