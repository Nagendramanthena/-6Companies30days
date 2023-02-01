class Solution {

    double r;
    double x;
    double y;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
       double randomradius= Math.sqrt(Math.random())*r;
        double max=361;
        double min = -361;
        double radians = ((Math.random() * (max - min)) + min);
        double x1 = x+randomradius*Math.sin(radians);
        double y1 = y+randomradius*Math.cos(radians);
        
        return new double[]{x1,y1};
    }
}
