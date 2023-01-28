class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
       Arrays.sort(asteroids);
        long m = (long) mass;
        for(int i:asteroids){
            if(m>100_100)return true;
            if(m<i)return false;
            else m+=i;
        }
        return true;
    }
}
