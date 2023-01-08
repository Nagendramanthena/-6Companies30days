link:
https://leetcode.com/problems/maximum-points-in-an-archery-competition/

simplebacktracking


code:

class Solution {
    int ans[] = new int[12];
    int currmax = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        bt(numArrows,aliceArrows,0,11,new int[12]);
        return ans;
    }
    public void bt(int n,int a[],int points,int index,int b[]){
        
        if(n<0 || index<0){
            if(n>0)b[0]+=n;
            if(points>currmax){
                currmax = points;
                ans = Arrays.copyOf(b,12);
                return;
            }
            return;
        }
    
        //section1
        if(n>a[index]){
            b[index]= a[index]+1;
            bt(n-a[index]-1,a,points+index,index-1,b);
            b[index] =0;
        }
        
        //section2
        bt(n,a,points,index-1,b);
        b[index]=0;
    }
}
