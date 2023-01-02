//problem Link:
https://leetcode.com/problems/perfect-rectangle/



//code
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        HashSet<String> set = new HashSet<>();
        int area = 0;
        
        for(int r[]:rectangles){
            x1 = Math.min(r[0],x1);
            y1 = Math.min(r[1],y1);
            x2 = Math.max(r[2],x2);
            y2 = Math.max(r[3],y2);
            
            area += (r[2]-r[0])*(r[3]-r[1]);
            
            String point1 = r[0]+" "+r[1];
            String point2 = r[2]+" "+r[1];
            String point3 = r[0]+" "+r[3];
            String point4 = r[2]+" "+r[3];
            
            if(!set.add(point1))set.remove(point1);
            if(!set.add(point2))set.remove(point2);
            if(!set.add(point3))set.remove(point3);
            if(!set.add(point4))set.remove(point4);
        }
        
        if(!set.contains(x1+" "+y1) || !set.contains(x1+" "+y2)
           ||!set.contains(x2+" "+y2)||!set.contains(x2+" "+y1) || set.size()!=4) return false;
        
        return (area == (x2-x1)*(y2-y1));
    }
}
