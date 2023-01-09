link:
https://leetcode.com/problems/invalid-transactions/









code:
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Pair t[] = new Pair[n];
        int i=0;
        for(String s:transactions){
            String arr[] = s.split(",");
            int a = Integer.parseInt(arr[2]);
            int time = Integer.parseInt(arr[1]);
            Pair p = new Pair(arr[0],time,a,arr[3],i);
            t[i++]=p;
        }
        HashSet<String> invalid = new HashSet<>();
        List<String> ans = new ArrayList<>();
        HashMap<String,List<data>> hm = new HashMap<>();
        for(i=0;i<n;i++){
            Pair p = t[i];
            
            if(hm.containsKey(p.name)){
                List<data> temp = hm.get(p.name);
                if(p.amount>1000){
                    if(invalid.add(transactions[p.index]+p.index)){
                        ans.add(transactions[p.index]);
                    }
                }
                for(int j=0;j<temp.size();j++){
                    if(!p.city.equals(temp.get(j).city) && Math.abs(p.time-temp.get(j).time)<=60){
                        if(invalid.add(transactions[p.index]+p.index)){
                            ans.add(transactions[p.index]);
                        }
                        if(invalid.add(transactions[temp.get(j).index]+temp.get(j).index)){
                            ans.add(transactions[temp.get(j).index]);
                        }
                    }
                }
                temp.add(new data(p.time,p.index,p.city));
                hm.replace(p.name,temp);
                
                }
            else{
                if(p.amount>1000){
                    if(invalid.add(transactions[p.index]+p.index)){
                    ans.add(transactions[p.index]);
                }
                }
                List<data> temp = new ArrayList<>();
                temp.add(new data(p.time,p.index,p.city));
                hm.put(p.name,temp);
            }
        }
        return ans;
    }
}

class Pair{
    
    String name;
    int time;
    int amount;
    String city;
    int index;
    
    public Pair(String s,int t,int a,String c,int index){
        this.name = s;
        this.time = t;
        this.amount = a;
        this.city = c;
        this.index = index;
    }
}

class data{
    int time;
    int index;
    String city;
    
    public data(int time,int index,String city){
        this.time = time;
        this.index = index;
        this.city =city;
    }
}
