class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] q) {
        int ans[] = new int[q.length];
        for(int i=0;i<q.length;i++){
            int qry = q[i][1];
            PriorityQueue<Pair> pq = new PriorityQueue<>(new myc());
            for(int j=0;j<nums.length;j++){
                int x = nums[j].length()-qry;
                pq.add(new Pair(j,nums[j].substring(x)));
            }
            int k = q[i][0];
            while(k>1){
                pq.poll();
                k--;
            }
            ans[i] = pq.peek().index;
        }
        return ans;
    }
}

class Pair{
    int index;
    String num;
    
    public Pair(int i,String n){
        this.index = i;
        this.num = n;
    }
    
}

class myc implements  Comparator<Pair>{
    public int compare(Pair a,Pair b){
        int y = Sc(a.num,b.num,a.num.length());
        if(y==-2){
            if(a.index>b.index)return 1;
            else if(a.index<b.index) return -1;
            else return 0;
        }
        return y;
    }
    public int Sc(String s1,String s2,int len){
        int l = 0;
        int val1 = s1.charAt(l);int val2 = s2.charAt(l);
        
        if(val1>val2)return 1;
        else if(val1<val2)return -1;
        else{
            if(s1.length() == 1)return -2;
            else return Sc(s1.substring(1),s2.substring(1),len);
        }
}
}
