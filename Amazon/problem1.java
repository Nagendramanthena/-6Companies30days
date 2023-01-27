class Solution {
    
    int o[];
    int n ;
    List<Integer> ori = new ArrayList<>();

    public Solution(int[] nums) {
        o=nums;
        n = nums.length;
        for(int i=0;i<n;i++){
            ori.add(nums[i]);
        }
    }
    
    public int[] reset() {
        return o;
    }
    
    public int[] shuffle() {
        List<Integer> l = new ArrayList<>(ori);
        
        int ans[] = new int[n];
        int i=0;
        while(i<n){
            int max = l.size();
            int min = 0;
            int random  =(int) (Math.random()*max);
            ans[i++] = l.get(random);
            l.remove(random);
        }
        return ans;
    }
}
