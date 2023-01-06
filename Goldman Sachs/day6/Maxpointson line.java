link:https://leetcode.com/problems/max-points-on-a-line/


code:
 class Point {
     int x;
     int y;
    Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}

// simpler solution

class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length;
        
        int maxi = 0;
        for(int i=0;i<n;i++){
            
            HashMap<String,Integer> hm = new HashMap<>();
            int dup = 0;
            
            for(int j=0;j<n;j++){
                
                int dy = points[i][1]-points[j][1];
                int dx = points[i][0]-points[j][0];
                
                if(dx ==0 && dy == 0)dup++;
                
                else {
                     int gg = GCD(Math.abs(dx),Math.abs(dy));
                
                dx/=gg;
                dy/=gg;
                    String tp = dx+" "+dy;
                hm.put(tp,hm.getOrDefault(tp,0)+1);
                
                    
                }
            }
            maxi = Math.max(maxi,dup);
            
            
            for(Map.Entry<String,Integer> me:hm.entrySet()){
                maxi = Math.max(me.getValue()+dup,maxi);
            }
        }
        
        return maxi;
    }
    public int GCD(int x,int y){
        
        if(y == 0)return x;
        
        return GCD(y,x%y);
        
    }
}

class Pair{
    int f;
    int s;
    public Pair(int f,int s){
        this.f = f;
        this.s = s;
    }
}
