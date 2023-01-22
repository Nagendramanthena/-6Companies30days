class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return f(students,mentors,new int[mentors.length],0);
    }
    
    public int f(int s[][],int m[][],int ass[],int index){
        
        if(index>s.length-1){
            return 0;
        }
        int max = 0;
        for(int i=0;i<m.length;i++){
           if(ass[i] == 0){
               int score = 0;
               ass[i]=1;
               for(int j=0;j<m[i].length;j++){
                   if(s[index][j] == m[i][j]) score++;
               }
               int go = score+f(s,m,ass,index+1);
               max = Math.max(go,max);
               ass[i] = 0;
           }   
        }
        return max;
    }
}
