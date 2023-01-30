class Solution {
    public String predictPartyVictory(String senate) {
        int p[] = new int[2];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R')p[1]++;
            else p[0]++;
            q.add(i);
        }
        int p1 = 0;
        int p2 = 0;
            while(!q.isEmpty()){
                Integer i = q.poll();
                boolean toadd = true;
                if(senate.charAt(i) == 'R'){
                    if(p2>0){
                        p2--;
                        toadd = false;
                    }
                    else if(p[0]>1){
                        p[0]--;
                        p1++;
                    }
                    else return "Radiant";
                }
            else if(senate.charAt(i) == 'D'){
                    if(p1>0){
                        p1--;
                        toadd = false;
                    }
                    else if(p[1]>1){
                        p[1]--;
                        p2++;
                    }
                    else return "Dire";
                }
                if(toadd)q.add(i);
        }
        return "NoOne";
            }
        
        
    }
