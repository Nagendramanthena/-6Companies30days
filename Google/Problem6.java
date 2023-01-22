class Solution {
    public int maxCoins(int[] piles) {
        int max_coins =0;
        Arrays.sort(piles);
        int start = 0;
        for(int i=piles.length-2;i>=start;i -= 2){
            start +=1;
            max_coins += piles[i];
        }
        return max_coins;
    }
}
