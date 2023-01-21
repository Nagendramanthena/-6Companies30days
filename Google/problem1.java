class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int j = 0;
        int curr = 0;int max = 0;
        int i = bottom;
        while(i<=top && j<special.length){
            max = Math.max(max,special[j]-i);
            i = special[j]+1;
            j++;
        }
        int rem = top-i+1;
        max = Math.max(rem,max);
        return max;
    }
}
