link:
https://leetcode.com/problems/number-of-boomerangs/

intution:
take a point store the distance with that point and number of points having same distance if(hm.get(distance>2) then that pair will be a boomerang



code:
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int n=points.length;
        int ans= 0;
        
        for(int i=0;i<n;i++){
            
            HashMap<Integer,Integer> hm = new HashMap<>();
            
            for(int j=0;j<n;j++){
                if(i!=j){
                int dis = gd(points[i],points[j]);
                    hm.put(dis,hm.getOrDefault(dis,0)+1);
                    }
            }
            for(Map.Entry<Integer,Integer> me:hm.entrySet()){
                if(me.getValue()>=2){
                    int val = me.getValue();
                    ans += (val*(val-1));
                }
            }
            
        }
        return ans;
    }
    public int gd(int p1[],int p2[]){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
