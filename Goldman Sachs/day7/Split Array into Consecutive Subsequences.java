link:
https://leetcode.com/problems/split-array-into-consecutive-subsequences/



sorting:sort according to the end first if there is a tie we need to sort according the length

ex:1 2 3 3 4 5
  take this example
  
intially 1,1,1 will be pushed
then 1,2,2 will pushed
then 1,3,3
 now comes 3 here we will add new interval 1,3,3
                                           3,3,1
  
  if we dont sort in ascending order this will happen
  1,4,4 -->3,3,1
   1,5,5-->3,3,1
    
   else condition
   
   1,3,3-->3,4,3
     1,3,3-->3,5,3
     
    sorting in ascending order of length will give a chance for pairs having less length to meet the length 3 if there is a chance



code:
class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((t1,t2)->t1.end == t2.end?t1.length-t2.length:t1.end-t2.end);
        
        for(int num:nums){
            
            while(!pq.isEmpty() && pq.peek().end+1<num){
                if(pq.poll().length<3)return false;
            }
            
            if(pq.isEmpty() || pq.peek().end == num){
                pq.add(new tuple(num,num,1));
            }
            else{
                tuple t = pq.poll();
                pq.add(new tuple(t.start,num,t.length+1));
            }
        }
        
        while(!pq.isEmpty()){
            if(pq.poll().length<3)return false;
        }
        
        return true;
    }
}



class tuple{
    int start;
    int end;
    int length;
    
    public tuple(int s,int e,int l){
        start = s;
        end =e;
        length=l;
    }
}
