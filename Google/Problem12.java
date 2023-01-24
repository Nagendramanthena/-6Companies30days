class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        getAll(nums, set, k, p);
        return set.size();
    }
    
    private void getAll(int[] nums, Set<String> res, int k, int p) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            int countK = 0;
            for (int j = i; j < N && countK <= k; j++) {
                if (nums[j] % p == 0) countK++;
                sb.append(",").append(nums[j]);
                if (countK <= k) res.add(sb.toString());
            }
        }
    }
}
