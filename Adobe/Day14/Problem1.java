BruteForce

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0;
        
        int m = matrix.length;int n = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.add(Math.abs(matrix[i][j]));
                if(matrix[i][j]<0)neg++;
            }
        }
        boolean odd = false;
        int len = pq.size();
        if(neg%2!=0){
            len--;
            odd = true;
        }
        
        while(len>0){
            sum+=pq.poll();
            len--;
        }
        
        if(odd)sum -= pq.peek();
        
        
        return sum;
    }
}





//Better Alogorithm

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0;
        long min = Long.MAX_VALUE;
        
        int m = matrix.length;int n = matrix[0].length;
    
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum += Math.abs(matrix[i][j]);
                min = Math.min(Math.abs(matrix[i][j]),min);
                if(matrix[i][j]<0)neg++;
            }
        }
        if(neg%2!=0)sum-=2*min;
        
        return sum;
    }
}
