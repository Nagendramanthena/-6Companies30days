class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        return winner(arr,0,k);
        
    }
    
    public int winner(List<Integer> arr,int index,int k){
        if(arr.size()==1)return arr.get(0);
        
        int tbr = index+k-1;
        
        int y  = tbr/arr.size();
        
        tbr-=y*arr.size();
        arr.remove(tbr);
        index=tbr;
        
        return winner(arr,index,k);
    }
}
