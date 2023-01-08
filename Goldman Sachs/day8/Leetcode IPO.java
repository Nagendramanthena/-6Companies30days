link:

https://leetcode.com/problems/ipo/



intuition:1.store (profit,capital) pairs in an array
2.then sort them int the ascending order of capital
3.use a pointer start which points the locked project with minimal capital in the array
4.for each k our capital will increase so push all the new projects that were unlocked into a priorityqueue
5.pop out the one with most profit;











code:


class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=capital.length;
        Pair ap[] = new Pair[n];
        for(int i=0;i<n;i++){
            ap[i] = new Pair(capital[i],profits[i]);
        }
        
        Arrays.sort(ap,(a,b)->a.capital-b.capital);
        int start = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        while(k>0){
            
            while(start<n && ap[start].capital<=w){
                pq.add(ap[start].profit);
                start++;
            }
            
            if(pq.isEmpty()) return w;
            
            w+=pq.poll();
            k--;
        }
        return w;
    }
}

class Pair {
    
    int capital;
    int profit;
    
    public Pair(int capital,int profit){
        this.capital = capital;
        this.profit = profit;
    }
    
}
