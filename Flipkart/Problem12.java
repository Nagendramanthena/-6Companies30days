class Solution {
    public String customSortString(String order, String s) {
        int m = order.length();int n = s.length();
        int c[] = new int[26];
        for(int i=0;i<m;i++){
            c[order.charAt(i)-97]++;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<n;i++){
            if(c[s.charAt(i)-97]>0){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            }
            else{
                hm2.put(s.charAt(i),hm2.getOrDefault(s.charAt(i),0)+1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x1,x2)->order.indexOf(x1.c)-order.indexOf(x2.c));
        hm.forEach((k,v)-> pq.add(new Pair(k,v)));
        String ans = "";
        while(!pq.isEmpty()){
            Pair p = pq.poll();char ch = p.c;int fr=p.a;
            
            while(fr>0){
                ans += ch;fr--;
            }
        }
        
        for(Character ch:hm2.keySet()){
            int v = hm2.get(ch);
            while(v!=0){
                ans += ch;v--;
            }
        }
            
          return ans;
        
    }
}

class Pair{
    char c;int a;
    
    public Pair(char c,int a){
        this.c = c;this.a=a;
    }
}
