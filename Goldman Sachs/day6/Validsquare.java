link:
https://leetcode.com/problems/valid-square/



intution:(all the sides are equal and two diagonals are equal)
code:
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(Arrays.equals(p1,p2))return false;
       
        int a[] = new int[6];
        a[0] = dist(p1,p2);
        a[1] = dist(p1,p3);
        a[2] = dist(p1,p4);
        a[3] = dist(p2,p3);a[4] = dist(p2,p4);
        a[5]=dist(p4,p3);
        Arrays.sort(a);
        if(a[0]==a[1] && a[1]==a[2] && a[2]==a[3]){
            return a[4]==a[5];
        }
        return false;
        
    }
    public int dist(int p1[],int p2[]){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
