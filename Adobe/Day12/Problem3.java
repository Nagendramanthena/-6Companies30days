public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(2);
        int j=4, sum=1;
        boolean one=true; // turn for one 
        while(j<n+1){
            int end = q.poll();
            while(end>0 && j<n+1){
                j++;
                if(one){
                    q.offer(1);
                    sum++;
                }
                else  
                    q.offer(2);
                end--;
                
            }
            one = !one; 
            
        }
        
        return sum;
        
    }
